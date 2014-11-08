package ch.bfh.funkyCoders.taskList.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class Task {
    public enum Status {
        OPEN, IN_PROGRESS, DONE;
    }

    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Basic
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private Date endDate;

    @Temporal(TemporalType.DATE)
    @Basic
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Status status;

    @Basic
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Project project;

    @ManyToOne
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private Person taskOwner;

    @ManyToOne
    public Person getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(Person taskOwner) {
        this.taskOwner = taskOwner;
    }

    private List<Tag> tags;

    @ManyToMany
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
