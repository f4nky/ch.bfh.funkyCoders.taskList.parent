/**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
import ch.bfh.funkyCoders.taskList.model.Task;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Fanky
 * 
 */
public class CreateIT {

	@Test
	public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Project project = new Project();
        project.setName("Project 1");
        project.setCosts(25000.00);
        project.setStartDate(sdf.parse("2014-01-01"));
        project.setEndDate(sdf.parse("2015-01-31"));

        Task task1 = new Task();
        task1.setName("P1 - Task 1");
        task1.setDescription("Lorem ipsum");
        task1.setStatus(Task.Status.OPEN);
        task1.setProject(project);

        Task task2 = new Task();
        task2.setName("P1 - Task 2");
        task2.setDescription("Lorem ipsum");
        task2.setStatus(Task.Status.DONE);
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
