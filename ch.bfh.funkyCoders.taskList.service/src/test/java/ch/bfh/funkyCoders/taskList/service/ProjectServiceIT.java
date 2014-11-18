package ch.bfh.funkyCoders.taskList.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.funkyCoders.taskList.service.dto.ProjectDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ProjectServiceIT {

	@Inject
	private ProjectService projectService;

	@Test
	public void test() {

		// Create
		ProjectDTO newProject = new ProjectDTO();
		newProject.setName("Test");
		newProject = projectService.create(newProject);

		// Read
		ProjectDTO readProject = projectService.read(newProject.getId());
		Assert.assertTrue(newProject.getName().equals(readProject.getName()));

		// Update
		readProject.setName("Test2");
		readProject = projectService.update(readProject);
		ProjectDTO updatedProject = projectService.read(readProject.getId());
		Assert.assertTrue(readProject.getName().equals(updatedProject.getName()));

		// Delete
		projectService.delete(updatedProject);
		ProjectDTO deletedProject = projectService.read(readProject.getId());
		Assert.assertNull(deletedProject);
	}

}
