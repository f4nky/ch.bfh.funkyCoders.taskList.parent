package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.TaskDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class TaskServiceIT {

	@Inject
	private TaskService taskService;

	@Test
	public void test() {

		// Create
		TaskDTO newTask = new TaskDTO();
		newTask.setName("Test");
		newTask = taskService.create(newTask);

		// Read
		TaskDTO readTask = taskService.read(newTask.getId());
		Assert.assertTrue(newTask.getName().equals(readTask.getName()));

		// Update
		readTask.setName("Test2");
		readTask = taskService.update(readTask);
		TaskDTO updatedTask = taskService.read(readTask.getId());
		Assert.assertTrue(readTask.getName().equals(updatedTask.getName()));

		// Delete
		taskService.delete(updatedTask);
		TaskDTO deletedTask = taskService.read(readTask.getId());
		Assert.assertNull(deletedTask);
	}

}
