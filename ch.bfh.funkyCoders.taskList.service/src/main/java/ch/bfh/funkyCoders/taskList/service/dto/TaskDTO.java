package ch.bfh.funkyCoders.taskList.service.dto;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class TaskDTO {
    public enum Status {
        OPEN, DELETED, DONE;
    }

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

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonBackReference
    private ProjectDTO project;

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    private PersonDTO taskOwner;

    public PersonDTO getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(PersonDTO taskOwner) {
        this.taskOwner = taskOwner;
    }

    private List<TagDTO> tags;

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
}
