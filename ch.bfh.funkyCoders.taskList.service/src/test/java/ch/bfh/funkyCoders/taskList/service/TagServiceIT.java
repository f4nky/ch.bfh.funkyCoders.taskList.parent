package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.TagDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class TagServiceIT {

	@Inject
	private TagService tagService;

	@Test
	public void test() {

		// Create
		TagDTO newTag = new TagDTO();
		newTag.setName("Test");
		newTag = tagService.create(newTag);

		// Read
		TagDTO readTag = tagService.read(newTag.getId());
		Assert.assertTrue(newTag.getName().equals(readTag.getName()));

		// Update
		readTag.setName("Test2");
		readTag = tagService.update(readTag);
		TagDTO updatedTag = tagService.read(readTag.getId());
		Assert.assertTrue(readTag.getName().equals(updatedTag.getName()));

		// Delete
		tagService.delete(updatedTag);
		TagDTO deletedTag = tagService.read(readTag.getId());
		Assert.assertNull(deletedTag);
	}

}
