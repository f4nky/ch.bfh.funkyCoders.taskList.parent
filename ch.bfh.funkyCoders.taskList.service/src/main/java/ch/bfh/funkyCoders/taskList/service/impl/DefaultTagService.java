package ch.bfh.funkyCoders.taskList.service.impl;

import ch.bfh.funkyCoders.taskList.model.Tag;
import ch.bfh.funkyCoders.taskList.repository.TagRepository;
import ch.bfh.funkyCoders.taskList.service.TagService;
import ch.bfh.funkyCoders.taskList.service.dto.TagDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Fanky on 25.11.14.
 */
public class DefaultTagService implements TagService {

    @Inject
    private TagRepository tagRepository;

    private final ModelMapper mapper = new ModelMapper();

    public TagDTO create(TagDTO tagDTO) {
        Tag tag = mapper.map(tagDTO, Tag.class);
        Tag persistedTag = tagRepository.save(tag);
        return mapper.map(persistedTag, TagDTO.class);
    }

    public TagDTO read(long id) {
        Tag tag = tagRepository.findOne(id);
        if (tag == null) return null;
        return mapper.map(tag, TagDTO.class);
    }

    public Collection<TagDTO> list() {
        Iterable<Tag> tags = tagRepository.findAll();
        Type listType = new TypeToken<Collection<TagDTO>>() {}.getType();
        return mapper.map(tags, listType);
    }

    public TagDTO update(TagDTO tagDTO) {
        Tag tag = mapper.map(tagDTO, Tag.class);
        Tag updatedTag = tagRepository.save(tag);
        return mapper.map(updatedTag, TagDTO.class);
    }

    public void delete(TagDTO tagDTO) {
        Tag tag = tagRepository.findOne(tagDTO.getId());
        tagRepository.delete(tag);
    }
}
