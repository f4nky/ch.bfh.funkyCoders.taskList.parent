package ch.bfh.funkyCoders.taskList.service.dto;

import org.codehaus.jackson.annotate.JsonBackReference;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class PersonDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String initials;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @JsonBackReference
    private List<ProjectDTO> projects;

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    //@JsonBackReference
    private List<TaskDTO> tasks;

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
