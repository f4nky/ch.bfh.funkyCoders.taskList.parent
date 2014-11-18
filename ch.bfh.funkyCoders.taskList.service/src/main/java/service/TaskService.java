package service;

import ch.bfh.funkyCoders.taskList.service.dto.PersonDTO;

import java.util.Collection;

/**
 * Created by Fanky on 18.11.14.
 */
public interface TaskService {
    public PersonDTO create(PersonDTO person);
    public PersonDTO read(long id);
    public Collection<PersonDTO> list();
    public PersonDTO update(PersonDTO person);
    public void delete(PersonDTO person);
}
