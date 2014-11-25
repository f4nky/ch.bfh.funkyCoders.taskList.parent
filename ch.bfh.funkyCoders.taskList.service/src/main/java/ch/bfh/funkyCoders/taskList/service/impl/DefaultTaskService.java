package ch.bfh.funkyCoders.taskList.service.impl;

import ch.bfh.funkyCoders.taskList.model.Task;
import ch.bfh.funkyCoders.taskList.repository.TaskRepository;
import ch.bfh.funkyCoders.taskList.service.TaskService;
import ch.bfh.funkyCoders.taskList.service.dto.TaskDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Fanky on 25.11.14.
 */
public class DefaultTaskService implements TaskService {

    @Inject
    private TaskRepository taskRepository;

    private final ModelMapper mapper = new ModelMapper();

    public TaskDTO create(TaskDTO taskDTO) {
        Task task = mapper.map(taskDTO, Task.class);
        Task persistedTask = taskRepository.save(task);
        return mapper.map(persistedTask, TaskDTO.class);
    }

    public TaskDTO read(long id) {
        Task task = taskRepository.findOne(id);
        if (task == null) return null;
        return mapper.map(task, TaskDTO.class);
    }

    public Collection<TaskDTO> list() {
        Iterable<Task> tasks = taskRepository.findAll();
        Type listType = new TypeToken<Collection<TaskDTO>>() {}.getType();
        return mapper.map(tasks, listType);
    }

    public TaskDTO update(TaskDTO taskDTO) {
        Task task = mapper.map(taskDTO, Task.class);
        Task updatedTask = taskRepository.save(task);
        return mapper.map(updatedTask, TaskDTO.class);
    }

    public void delete(TaskDTO taskDTO) {
        Task task = taskRepository.findOne(taskDTO.getId());
        taskRepository.delete(task);
    }
}
