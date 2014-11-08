package ch.bfh.funkyCoders.taskList.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Fanky on 08.11.14.
 */
@Entity
public class Tag {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Task> tasks;

    @ManyToMany
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
