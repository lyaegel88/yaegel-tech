package com.yaegel.tech.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaegel.tech.webapp.domain.Members;
import com.yaegel.tech.webapp.domain.repository.MembersRepository;
import com.yaegel.tech.webapp.service.MembersService;

@Controller
public class MembersController {
	
	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private MembersService membersService;

	@RequestMapping ("/members")
	public String list(Model model) {
		model.addAttribute("members", membersRepository.getAllMembers());
		
		return "members";
	}
	
	@RequestMapping ("/member")
	public String getMemberById(@RequestParam("id") String memberId, Model model) {
		model.addAttribute("member", membersService.getMemberById(memberId));
		
		return "member";
	}
	
	@RequestMapping (value= "/members/add", method = RequestMethod.GET)
	public String getAddNewMembersForm(Model model) {
		Members newMember = new Members();
		model.addAttribute("newMember", newMember);
		
		return "addMember";
	}
	
	@RequestMapping (value = "/members/add", method = RequestMethod.POST)
	public String processAddNewMembersForm(@ModelAttribute ("newMember") Members newMember) {
		membersService.addMember(newMember);
		
		return "redirect: /members";
	}
	
	@RequestMapping ("/member/delete")
	public String deleteMember(@RequestParam("id") String memberId) {
		membersService.deleteMember(memberId);
		
		return "redirect: /members";
	}
	
	@RequestMapping ("/members/manage")
	public String manageList(Model model) {
		model.addAttribute("members", membersRepository.getAllMembers());
		
		return "editMembers";
	}
}
