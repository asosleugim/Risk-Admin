package com.davo.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.Project;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/projectform*")
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
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Project project, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
 
        if (validator != null) { // validator is null during testing
            validator.validate(project, errors);
 
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "projectform";
            }
        }
 
        log.debug("entering 'onSubmit' method...");
 
        boolean isNew = (project.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();
 
        if (request.getParameter("delete") != null) {
            projectManager.remove(project.getId());
            saveMessage(request, getText("project.deleted", locale));
        } else {
        	projectManager.save(project);
            String key = (isNew) ? "person.added" : "person.updated";
            saveMessage(request, getText(key, locale));
 
            if (!isNew) {
                success = "redirect:projectform?id=" + project.getId();
            }
        }
 
        return success;
	}

}
