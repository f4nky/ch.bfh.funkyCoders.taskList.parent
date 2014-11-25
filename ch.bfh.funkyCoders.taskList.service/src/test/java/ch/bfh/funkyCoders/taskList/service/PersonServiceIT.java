package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.PersonDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class PersonServiceIT {

	@Inject
	private PersonService personService;

	@Test
	public void test() {

		// Create
		PersonDTO newPerson = new PersonDTO();
		newPerson.setName("Test");
		newPerson = personService.create(newPerson);

		// Read
		PersonDTO readPerson = personService.read(newPerson.getId());
		Assert.assertTrue(newPerson.getName().equals(readPerson.getName()));

		// Update
		readPerson.setName("Test2");
		readPerson = personService.update(readPerson);
		PersonDTO updatedPerson = personService.read(readPerson.getId());
		Assert.assertTrue(readPerson.getName().equals(updatedPerson.getName()));

		// Delete
		personService.delete(updatedPerson);
		PersonDTO deletedPerson = personService.read(readPerson.getId());
		Assert.assertNull(deletedPerson);
	}

}
