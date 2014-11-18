package ch.bfh.funkyCoders.taskList.repository;

import ch.bfh.funkyCoders.taskList.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Fanky on 18.11.14.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    
}
