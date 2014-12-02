package ch.bfh.funkyCoders.taskList.rest.controller;

import ch.bfh.funkyCoders.taskList.service.TaskService;
import ch.bfh.funkyCoders.taskList.service.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Inject
	private TaskService taskService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public TaskDTO createTask(@RequestBody TaskDTO task) {
		TaskDTO createdTask = taskService.create(task);
		System.out.println("Task created with id = " + createdTask.getId());
		return createdTask;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<TaskDTO> getTasks() {
		System.out.println("Collection of Task requested");
		return taskService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public TaskDTO getTask(@PathVariable long id) {
		System.out.println("Task requested with id = " + id);
		return taskService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public TaskDTO updateTask(@RequestBody TaskDTO task) {
		TaskDTO updatedTask = taskService.update(task);
		System.out.println("Task updated with id = " + updatedTask.getId());
		return updatedTask;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteTask(@PathVariable long id) {
		TaskDTO task = taskService.read(id);
		taskService.delete(task);
		System.out.println("Delete Task with id = " + id);
	}
}
