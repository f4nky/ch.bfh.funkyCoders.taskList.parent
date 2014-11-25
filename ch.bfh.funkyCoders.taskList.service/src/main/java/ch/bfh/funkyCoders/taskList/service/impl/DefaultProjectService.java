package ch.bfh.funkyCoders.taskList.service.impl;

import ch.bfh.funkyCoders.taskList.model.Project;
import ch.bfh.funkyCoders.taskList.repository.ProjectRepository;
import ch.bfh.funkyCoders.taskList.service.ProjectService;
import ch.bfh.funkyCoders.taskList.service.dto.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Fanky on 25.11.14.
 */
@Named
public class DefaultProjectService implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    private final ModelMapper mapper = new ModelMapper();

    public ProjectDTO create(ProjectDTO projectDTO) {
        Project project = mapper.map(projectDTO, Project.class);
        Project persistedProject = projectRepository.save(project);
        return mapper.map(persistedProject, ProjectDTO.class);
    }

    public ProjectDTO read(long id) {
        Project project = projectRepository.findOne(id);
        if (project == null) return null;
        return mapper.map(project, ProjectDTO.class);
    }

    public Collection<ProjectDTO> list() {
        Iterable<Project> projects = projectRepository.findAll();
        Type listType = new TypeToken<Collection<ProjectDTO>>() {}.getType();
        return mapper.map(projects, listType);
    }

    public ProjectDTO update(ProjectDTO projectDTO) {
        Project project = mapper.map(projectDTO, Project.class);
        Project updatedProject = projectRepository.save(project);
        return mapper.map(updatedProject, ProjectDTO.class);
    }

    public void delete(ProjectDTO projectDTO) {
        Project project = projectRepository.findOne(projectDTO.getId());
        projectRepository.delete(project);
    }
}
