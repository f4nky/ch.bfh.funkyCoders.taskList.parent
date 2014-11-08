/**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
import ch.bfh.funkyCoders.taskList.model.Task;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;

/**
 * @author Fanky
 * 
 */
public class CreateIT {

	@Test
	public void test() {
        Project project = new Project();
        project.setName("Project 1");
        project.setCosts(25000.00);

        Task task1 = new Task();
        task1.setTitle("P1 - Task 1");
        task1.setDescription("Lorem ipsum");
        task1.setProject(project);

        Task task2 = new Task();
        task2.setTitle("P1 - Task 2");
        task2.setDescription("Lorem ipsum");
        task2.setProject(project);

		ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(task1);
        tasks.add(task2);

        project.setTasks(tasks);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.funkyCoders.taskList.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
	}
}
