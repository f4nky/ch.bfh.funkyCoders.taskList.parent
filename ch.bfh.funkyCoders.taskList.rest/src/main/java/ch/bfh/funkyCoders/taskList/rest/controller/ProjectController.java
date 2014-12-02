package ch.bfh.funkyCoders.taskList.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.funkyCoders.taskList.service.ProjectService;
import ch.bfh.funkyCoders.taskList.service.dto.ProjectDTO;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Inject
	private ProjectService projectService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ProjectDTO createProject(@RequestBody ProjectDTO project) {
		ProjectDTO createdProject = projectService.create(project);
		System.out.println("Project created with id = " + createdProject.getId());
		return createdProject;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<ProjectDTO> getProjects() {
		System.out.println("Collection of Project requested");
		return projectService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProjectDTO getProject(@PathVariable long id) {
		System.out.println("Project requested with id = " + id);
		return projectService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ProjectDTO updateProject(@RequestBody ProjectDTO project) {
		ProjectDTO updatedProject = projectService.update(project);
		System.out.println("Project updated with id = " + updatedProject.getId());
		return updatedProject;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteProject(@PathVariable long id) {
		ProjectDTO project = projectService.read(id);
		projectService.delete(project);
		System.out.println("Delete Project with id = " + id);
	}
}
