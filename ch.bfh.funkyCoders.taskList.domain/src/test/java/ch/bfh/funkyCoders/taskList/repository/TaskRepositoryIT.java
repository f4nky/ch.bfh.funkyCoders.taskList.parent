package ch.bfh.funkyCoders.taskList.repository; /**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Task;
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
public class TaskRepositoryIT {

        @Inject
        private TaskRepository TaskRepository;

        @Test
        public void test() throws ParseException {

                // Create
                Task newTask = new Task();
                newTask.setName("Test");
                TaskRepository.save(newTask);

                // Read
                Task readTask = TaskRepository.findOne(newTask.getId());
                Assert.assertEquals(newTask.getName(), readTask.getName());

                // Update
                readTask.setName("Test2");
                readTask = TaskRepository.save(readTask);
                Task updatedTask = TaskRepository.findOne(readTask.getId());
                Assert.assertEquals(readTask.getName(), updatedTask.getName());

                // Delete
                TaskRepository.delete(updatedTask);
                Task deletedTask = TaskRepository.findOne(readTask.getId());
                Assert.assertNull(deletedTask);
        }
}
