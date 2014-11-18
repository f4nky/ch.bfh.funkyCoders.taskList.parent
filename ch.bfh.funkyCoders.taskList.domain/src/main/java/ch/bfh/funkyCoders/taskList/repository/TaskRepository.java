package ch.bfh.funkyCoders.taskList.repository;

import ch.bfh.funkyCoders.taskList.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fanky on 18.11.14.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

}
