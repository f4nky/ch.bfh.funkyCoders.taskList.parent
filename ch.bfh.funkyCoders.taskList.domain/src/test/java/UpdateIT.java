/**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Project;
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
public class UpdateIT {

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
        firstProject.setName("OtherName");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstProject.getName().equals("OtherName"));
	}

}
