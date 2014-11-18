package ch.bfh.funkyCoders.taskList.service;

import ch.bfh.funkyCoders.taskList.service.dto.TaskDTO;

import java.util.Collection;

/**
 * Created by Fanky on 18.11.14.
 */
public interface TaskService {
    public TaskDTO create(TaskDTO task);
    public TaskDTO read(long id);
    public Collection<TaskDTO> list();
    public TaskDTO update(TaskDTO task);
    public void delete(TaskDTO task);
}
