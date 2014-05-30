package com.davo.webapp.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

public class ProjectControllerTest extends BaseControllerTestCase{
	
	@Autowired
	private ProjectController controller;
	
	@Test
	public void testHandleRequest() throws Exception{
		ModelAndView mav = controller.handleRequest();
		ModelMap m = mav.getModelMap();
		
		assertNotNull(m.get("projectList"));
		
	}

}
