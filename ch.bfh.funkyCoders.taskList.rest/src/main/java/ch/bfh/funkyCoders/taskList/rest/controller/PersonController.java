package ch.bfh.funkyCoders.taskList.rest.controller;


import ch.bfh.funkyCoders.taskList.service.PersonService;
import ch.bfh.funkyCoders.taskList.service.dto.PersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Inject
	private PersonService personService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PersonDTO createPerson(@RequestBody PersonDTO person) {
		PersonDTO createdPerson = personService.create(person);
		System.out.println("Person created with id = " + createdPerson.getId());
		return createdPerson;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<PersonDTO> getPersons() {
		System.out.println("Collection of Person requested");
		return personService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PersonDTO getPerson(@PathVariable long id) {
		System.out.println("Person requested with id = " + id);
		return personService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public PersonDTO updatePerson(@RequestBody PersonDTO person) {
		PersonDTO updatedPerson = personService.update(person);
		System.out.println("Person updated with id = " + updatedPerson.getId());
		return updatedPerson;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePerson(@PathVariable long id) {
		PersonDTO person = personService.read(id);
		personService.delete(person);
		System.out.println("Delete Person with id = " + id);
	}
}
