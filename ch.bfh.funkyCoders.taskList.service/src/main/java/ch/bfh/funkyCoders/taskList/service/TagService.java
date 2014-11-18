package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.TagDTO;

import java.util.Collection;

/**
 * Created by Fanky on 18.11.14.
 */
public interface TagService {
    public TagDTO create(TagDTO tag);
    public TagDTO read(long id);
    public Collection<TagDTO> list();
    public TagDTO update(TagDTO tag);
    public void delete(TagDTO tag);
}
