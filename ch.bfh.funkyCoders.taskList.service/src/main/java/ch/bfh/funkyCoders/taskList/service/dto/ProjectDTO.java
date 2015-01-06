package ch.bfh.funkyCoders.taskList.service.dto;

import ch.bfh.funkyCoders.taskList.model.Person;
import ch.bfh.funkyCoders.taskList.model.Task;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class ProjectDTO {
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

    private Double costs;

    public Double getCosts() {
        return costs;
    }

    public void setCosts(Double costs) {
        this.costs = costs;
    }

    @JsonFormat(pattern = "dd.MM.yy")
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonFormat(pattern = "dd.MM.yy")
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private List<TaskDTO> tasks;

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    private PersonDTO projectOwner;

    public PersonDTO getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(PersonDTO projectOwner) {
        this.projectOwner = projectOwner;
    }
}
