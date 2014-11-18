package ch.bfh.funkyCoders.taskList.repository; /**
 * 
 */

import ch.bfh.funkyCoders.taskList.model.Tag;
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
public class TagRepositoryIT {

        @Inject
        private TagRepository TagRepository;

        @Test
        public void test() throws ParseException {

                // Create
                Tag newTag = new Tag();
                newTag.setName("Test");
                TagRepository.save(newTag);

                // Read
                Tag readTag = TagRepository.findOne(newTag.getId());
                Assert.assertEquals(newTag.getName(), readTag.getName());

                // Update
                readTag.setName("Test2");
                readTag = TagRepository.save(readTag);
                Tag updatedTag = TagRepository.findOne(readTag.getId());
                Assert.assertEquals(readTag.getName(), updatedTag.getName());

                // Delete
                TagRepository.delete(updatedTag);
                Tag deletedTag = TagRepository.findOne(readTag.getId());
                Assert.assertNull(deletedTag);
        }
}
