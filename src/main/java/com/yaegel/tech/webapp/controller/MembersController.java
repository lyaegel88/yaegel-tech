package com.yaegel.tech.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
