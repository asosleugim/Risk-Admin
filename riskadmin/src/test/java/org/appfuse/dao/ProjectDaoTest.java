package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.Project;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProjectDaoTest extends BaseDaoTestCase {
	
	@Autowired
	private GenericDao<Project, Long> projectDao;
	
	@Test
	public void testProjectDao() throws Exception{
		List<Project> projects = projectDao.getAll();
		
		assertTrue(projects.size() > 0);
	}

}
