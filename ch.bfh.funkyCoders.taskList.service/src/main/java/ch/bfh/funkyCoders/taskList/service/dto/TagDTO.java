package ch.bfh.funkyCoders.taskList.service.dto;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class TagDTO {
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

    @JsonBackReference
    private List<TaskDTO> tasks;

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
