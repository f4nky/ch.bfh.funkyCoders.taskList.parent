package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.ProjectDTO;

import java.util.Collection;

/**
 * Created by Fanky on 18.11.14.
 */
public interface ProjectService {
    public ProjectDTO create(ProjectDTO project);
    public ProjectDTO read(long id);
    public Collection<ProjectDTO> list();
    public ProjectDTO update(ProjectDTO project);
    public void delete(ProjectDTO project);
}
