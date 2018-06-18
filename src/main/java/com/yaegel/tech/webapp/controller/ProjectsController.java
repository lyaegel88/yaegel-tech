package com.yaegel.tech.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectsController {
	
	@RequestMapping("/projects")
	public String home(Model model) {
		
		model.addAttribute("greeting", "Yaegel Technologies");
		
		return "projects";
	}
}