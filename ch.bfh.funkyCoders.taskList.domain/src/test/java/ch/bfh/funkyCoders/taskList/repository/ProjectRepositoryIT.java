package ch.bfh.funkyCoders.taskList.repository; /**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
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
public class ProjectRepositoryIT {

        @Inject
        private ProjectRepository projectRepository;

        @Test
        public void test() throws ParseException {

                // Create
                Project newProject = new Project();
                newProject.setName("Test");
                projectRepository.save(newProject);

                // Read
                Project readProject = projectRepository.findOne(newProject.getId());
                Assert.assertEquals(newProject.getName(), readProject.getName());

                // Update
                readProject.setName("Test2");
                readProject = projectRepository.save(readProject);
                Project updatedProject = projectRepository.findOne(readProject.getId());
                Assert.assertEquals(readProject.getName(), updatedProject.getName());

                // Delete
                projectRepository.delete(updatedProject);
                Project deletedProject = projectRepository.findOne(readProject.getId());
                Assert.assertNull(deletedProject);
        }
}
