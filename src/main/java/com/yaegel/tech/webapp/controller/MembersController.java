package com.yaegel.tech.webapp.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.service.MembersService;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Controller
public class MembersController {
	
	@Autowired
	private Cloudinary cloudinaryBean;
	
	@Autowired
	private MembersService membersService;

	@RequestMapping ("/members")
	public String list(@RequestParam("page") int page, Model model) {

		int pagenumber = page;
		model.addAttribute("pagenumber", pagenumber);
		
		int start = 0;
		int stop = 7;
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

			model.addAttribute("members", membersService.getAllMembers(start, stop));
		}else{
			int stopSQL = 7;
			int pageNumber = pagenumber - 1;
			int startSQL = 7 * pageNumber; //may need to minus 1 if extra is returned 
			model.addAttribute("stop", stopSQL);
			model.addAttribute("start", startSQL);
			model.addAttribute("members", membersService.getAllMembers(startSQL, stopSQL));
			
		}

		
		return "members";
	}
	
	@RequestMapping ("/member")
	public String getMemberById(@RequestParam("id") String memberId, @RequestParam("page") String page, Model model) throws IOException {
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
		
		MultipartFile customerImage = newMember.getCustomerImage();
		
		if (customerImage !=null && !customerImage.isEmpty()) {
			
			try {
				File convFile = new File(newMember.getCustomerId() + ".png");
				
				customerImage.transferTo(convFile);
				
				@SuppressWarnings("rawtypes")
				Map uploadResult = cloudinaryBean.uploader().upload(convFile, ObjectUtils.asMap("public_id", newMember.getCustomerId(), "format", "png"));
				
				String url = (String)uploadResult.get("secure_url");
				
				newMember.setCustomerImageUrl(url);
				
			} catch (Exception e) {
				throw new RuntimeException("Member Image Failed to Save", e);
			}
			
		}	
		
		membersService.addMember(newMember);
		
		redirectAttributes.addFlashAttribute("success", "<div class=\"alert alert-success\">User was successfully ADDED</div>");
		
		return new RedirectView("add");
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
	
		            	cloudinaryBean.uploader().destroy(memberId, ObjectUtils.emptyMap());
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
		
		ra.addFlashAttribute("deleted", "<div class=\"alert alert-success\">User was successfully DELETED</div>");
		
		return new RedirectView("../members/manage?page=1");
	}
	
	@RequestMapping ("/members/manage")
	public String manageList (@RequestParam("page") int page, Model model) {

		int pagenumber = page;
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
			
		}
		
		return "editMembers";
	}
	
}
