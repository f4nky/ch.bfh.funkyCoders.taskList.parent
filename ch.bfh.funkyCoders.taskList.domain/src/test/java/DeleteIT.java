/**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rovi
 * 
 */
public class DeleteIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.funkyCoders.taskList.domain").createEntityManager();

		Query q = em.createQuery("select p from Project p");
		@SuppressWarnings("unchecked")
		List<Project> foundProjects = q.getResultList();
		Project firstProject = foundProjects.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstProject);
		em.getTransaction().commit();
	}

}
