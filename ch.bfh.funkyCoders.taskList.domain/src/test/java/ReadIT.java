/**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
import ch.bfh.funkyCoders.taskList.model.Task;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Fanky
 * 
 */
public class ReadIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.funkyCoders.taskList.domain").createEntityManager();

		Query q = em.createQuery("select p from Project p");
		@SuppressWarnings("unchecked")
		List<Project> foundProjects = q.getResultList();
		Project firstProject = foundProjects.get(0);
		Assert.assertTrue(firstProject.getCosts() == 25000.00);

		List<Task> foundTasks = firstProject.getTasks();
		Task firstTask = foundTasks.get(0);
		Assert.assertTrue(firstTask.getTitle().equals("P1 - Task 1"));
	}

}
