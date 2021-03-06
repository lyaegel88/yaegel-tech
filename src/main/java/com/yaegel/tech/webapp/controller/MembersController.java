package com.yaegel.tech.webapp.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.exception.NoMemberFoundException;
import com.yaegel.tech.webapp.exception.SpringException;
import com.yaegel.tech.webapp.service.MembersService;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class MembersController {
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private MembersService membersService;

	@RequestMapping ("/members")
	public String list(@RequestParam("page") int page, Model model) {
		
		//Page Number from URL e.g. page=1
		int pagenumber = page;
		model.addAttribute("pagenumber", pagenumber);
		
		//Row count for following calculations
		int maxrows = membersService.getMemberCount();
		
		//Find the Max number of pages and see if an extra page is needed
		if (maxrows >= 7){
			int maxpages = maxrows / 7;
			int pageTest = maxpages * 7; 
			int addPage = maxrows - pageTest;
			int zero = 0;
		//Add an extra page if TRUE
			if (addPage > zero){
				int extraPage = maxpages + 1;
				model.addAttribute("maxpages", extraPage);
		//Do not add an extra page if FALSE		
			}else {
				model.addAttribute("maxpages", maxpages);
			}
		//Only one page is needed because at least 7 rows are not available 
		}else{
			model.addAttribute("maxpages", 1);
		 }
		//pull the first 7 on page 1
		if (pagenumber <= 1) {

			model.addAttribute("members", membersService.getAllMembers(0, 7));
		}else{
			int stopSQL = 7; //Offset
			int pageNumber = pagenumber - 1; 
			int startSQL = 7 * pageNumber; //What row should the query start at, e.g. 7 * 2 = 14 (start at row 14 and pull the next 7 rows)

			model.addAttribute("members", membersService.getAllMembers(startSQL, stopSQL));
			
		}

		
		return "members";
	}
	
	@RequestMapping ("/member")
	public String getMemberById(@RequestParam("id") String memberId, @RequestParam(value="page", required=false) String page, Model model) throws IOException {
		List<Members> exist = membersService.getMemberExists(memberId);
		
		if(exist== null || exist.isEmpty()) {
			throw new NoMemberFoundException();
		}
		
		model.addAttribute("member", membersService.getMemberById(memberId));
		model.addAttribute("pagenumber", page);
		
		return "member";
	}
	
	@RequestMapping (value= "/members/add", method = RequestMethod.GET)
	public String getAddNewMembersForm(@ModelAttribute("success") String success, Model model) {
		Members newMember = new Members();
		model.addAttribute("newMember", newMember);
		model.addAttribute("success", success);
		
		return "addMember";
	}
	
	@RequestMapping (value = "/members/add", method = RequestMethod.POST)
	public RedirectView processAddNewMembersForm(@ModelAttribute ("newMember") Members newMember, RedirectAttributes redirectAttributes) throws IOException {
		
	
		List<Members> exist = membersService.getMemberExists(newMember.getCustomerId());
		
		if(exist == null || exist.isEmpty()) {
		
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(newMember.getCustomerPassword());
			
			newMember.setCustomerPassword(hashedPassword);
			
			MultipartFile customerImage = newMember.getCustomerImage();
			
			if (customerImage !=null && !customerImage.isEmpty()) {
				
				try {
					File convFile = new File(newMember.getCustomerId() + ".png");
					
					customerImage.transferTo(convFile);
					
	
					/*
					Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
							  "cloud_name", "hitfox6pi",
							  "api_key", "939334414551673",
							  "api_secret", "BTyM6j7y3SFNCnMvZDj8obSzP10"));*/
					
					@SuppressWarnings("rawtypes")
					Map uploadResult = cloudinary.uploader().upload(convFile, ObjectUtils.asMap("public_id", newMember.getCustomerId(), "format", "png"));
					
					String url = (String)uploadResult.get("secure_url");
					
					newMember.setCustomerImageUrl(url);
					
				} catch (Exception e) {
					throw new RuntimeException("Member Image Failed to Save", e);
				}
				
			}else {
				throw new SpringException("No image has been selected. Please add an image when creating a member.");
			}
			
			membersService.addMember(newMember); 
			
		}else {
			throw new SpringException("Member Already Exists!");
		}
		
		//Sending Logs to Papertrail Heroku Plugin
		System.out.println("New Member Added with Customer ID: " + newMember.getCustomerId() + " and Image URL: " + newMember.getCustomerImageUrl());
		
		redirectAttributes.addFlashAttribute("success", "<div class=\"alert alert-success\">User was successfully ADDED</div>");
		
		return new RedirectView("add");
	}
	
	@ExceptionHandler({SpringException.class})
	public String handleError(Model model, SpringException ex) {
		
		model.addAttribute("exception", ex.getExceptionMsg());
		
		return "ExceptionPage";
	}
	
	@RequestMapping ("/member/delete")
	public RedirectView deleteMember(@RequestParam("id") String memberId, RedirectAttributes ra) throws IOException {
		
		Members mem = new Members();
		
		mem = membersService.getMemberById(memberId);
		
		if (mem.getCustomerImageUrl() !=null && !mem.getCustomerImageUrl().isEmpty()) {
			
			try {  
		            BufferedImage image = ImageIO.read(new URL(mem.getCustomerImageUrl()));  
		            //BufferedImage image = ImageIO.read(new URL("http://someimage.jpg"));  
		            if(image != null){
		            	

		            	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		            			  "cloud_name", "hitfox6pi",
		            			  "api_key", "939334414551673",
		            			  "api_secret", "BTyM6j7y3SFNCnMvZDj8obSzP10"));
	
		            	cloudinary.uploader().destroy(memberId, ObjectUtils.emptyMap());
		            }
	
		        } catch (MalformedURLException e) {    
		            System.err.println("URL error with image");  
		            e.printStackTrace();
		            
		        } catch (IOException e) {  
		            System.err.println("IO error with image");  
		            e.printStackTrace(); 
		            
		        }
		        
		}
		
		membersService.deleteMember(memberId);
		
		//Sending Logs to Papertrail Heroku Plugin
		System.out.println("The following Member was Deleted: " + memberId);
		
		ra.addFlashAttribute("deleted", "<div class=\"alert alert-success\">User was successfully DELETED</div>");
		
		return new RedirectView("../members/manage?page=1");
	}
	
	@RequestMapping ("/members/manage")
	public String manageList (@RequestParam("page") int page, Model model) {
		
		Integer newPage = page;
		
		List<Members> members = membersService.getEveryMember();
		
		PagedListHolder<Members> pagedListHolder = new PagedListHolder<>(members);
		
		pagedListHolder.setPageSize(7);
		
		model.addAttribute("maxPages", pagedListHolder.getPageCount());
		
		if(newPage==null || newPage < 1 || newPage > pagedListHolder.getPageCount())newPage=1;
		
		model.addAttribute("page", newPage);
		
		if(newPage == null || newPage < 1 || newPage > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("members", pagedListHolder.getPageList());
		
		}else if(newPage <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(newPage-1);
            model.addAttribute("members", pagedListHolder.getPageList());
        }
		/*int pagenumber = page;
		model.addAttribute("pagenumber", pagenumber);
		
		int start = 0;
		int offset = 7;
		int maxrows = membersService.getMemberCount();
		
		if (maxrows >= 7){
			int maxpages = maxrows / 7;
			int pageTest = maxpages * 7; 
			int addPage = maxrows - pageTest;
			int zero = 0;
			
			if (addPage > zero){
				int extraPage = maxpages + 1;
				model.addAttribute("maxpages", extraPage);
				
			}else {
				model.addAttribute("maxpages", maxpages);
			}
		}else{
			model.addAttribute("maxpages", 1);
		 }
		
		if (pagenumber <= 1) {

			model.addAttribute("members", membersService.getAllMembers(start, offset));
		}else{
			//Remember SQL LIMIT in MYSQL uses an offset
			int stopSQL = 7; 
			int pageNumber = pagenumber - 1;
			int startSQL = 7 * pageNumber; //
			model.addAttribute("stop", stopSQL);
			model.addAttribute("start", startSQL);
			model.addAttribute("members", membersService.getAllMembers(startSQL, stopSQL));
			
		}*/
		
		return "editMembers2";
	}
	
}
