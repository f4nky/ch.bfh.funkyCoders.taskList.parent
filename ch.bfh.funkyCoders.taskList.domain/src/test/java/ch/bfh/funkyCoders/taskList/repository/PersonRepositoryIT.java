package ch.bfh.funkyCoders.taskList.repository; /**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.ParseException;

/**
 * @author Fanky
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class PersonRepositoryIT {

        @Inject
        private PersonRepository PersonRepository;

        @Test
        public void test() throws ParseException {

                // Create
                Person newPerson = new Person();
                newPerson.setName("Test");
                PersonRepository.save(newPerson);

                // Read
                Person readPerson = PersonRepository.findOne(newPerson.getId());
                Assert.assertEquals(newPerson.getName(), readPerson.getName());

                // Update
                readPerson.setName("Test2");
                readPerson = PersonRepository.save(readPerson);
                Person updatedPerson = PersonRepository.findOne(readPerson.getId());
                Assert.assertEquals(readPerson.getName(), updatedPerson.getName());

                // Delete
                PersonRepository.delete(updatedPerson);
                Person deletedPerson = PersonRepository.findOne(readPerson.getId());
                Assert.assertNull(deletedPerson);
        }
}
