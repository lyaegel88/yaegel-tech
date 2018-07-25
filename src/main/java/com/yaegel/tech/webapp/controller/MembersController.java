package com.yaegel.tech.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yaegel.tech.webapp.domain.repository.MembersRepository;

@Controller
public class MembersController {
	
	@Autowired
	private MembersRepository membersRepository;

	@RequestMapping ("/members")
	public String list(Model model) {
		model.addAttribute("members", membersRepository.getAllMembers());
		
		return "members";
	}
}
