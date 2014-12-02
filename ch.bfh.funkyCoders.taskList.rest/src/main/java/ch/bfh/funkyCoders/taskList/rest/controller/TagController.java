package ch.bfh.funkyCoders.taskList.rest.controller;

import ch.bfh.funkyCoders.taskList.service.TagService;
import ch.bfh.funkyCoders.taskList.service.dto.TagDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Inject
	private TagService tagService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public TagDTO createTag(@RequestBody TagDTO tag) {
		TagDTO createdTag = tagService.create(tag);
		System.out.println("Tag created with id = " + createdTag.getId());
		return createdTag;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<TagDTO> getTags() {
		System.out.println("Collection of Tag requested");
		return tagService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public TagDTO getTag(@PathVariable long id) {
		System.out.println("Tag requested with id = " + id);
		return tagService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public TagDTO updateTag(@RequestBody TagDTO tag) {
		TagDTO updatedTag = tagService.update(tag);
		System.out.println("Tag updated with id = " + updatedTag.getId());
		return updatedTag;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteTag(@PathVariable long id) {
		TagDTO tag = tagService.read(id);
		tagService.delete(tag);
		System.out.println("Delete Tag with id = " + id);
	}
}
