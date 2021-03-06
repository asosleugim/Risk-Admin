package com.davo.webapp.controller;

import org.appfuse.model.Project;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/projects*")
public class ProjectController {
	private GenericManager<Project, Long> projectManager;
	
	@Autowired
	public void setProjectManager(@Qualifier("projectManager") GenericManager<Project, Long> projectManager){
		this.projectManager = projectManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception{
		return new ModelAndView().addObject(projectManager.getAll());
	}
}
