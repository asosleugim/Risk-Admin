package com.davo.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.Project;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProjectFormController extends BaseFormController {
	
	private GenericManager<Project, Long> projectManager;
	
	@Autowired
	public void setProjectManager(@Qualifier("projectManager") GenericManager<Project, Long> projectManager){
		this.projectManager = projectManager;
	}
	
	public ProjectFormController(){
		setCancelView("redirect:projects");
		setSuccessView("redirec:projects");
	}
	
	@ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Project showForm(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
 
        if (!StringUtils.isBlank(id)) {
            return projectManager.get(new Long(id));
        }
 
        return new Project();
    }

}
