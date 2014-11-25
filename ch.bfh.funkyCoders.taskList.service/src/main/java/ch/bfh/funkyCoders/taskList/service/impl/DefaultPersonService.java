package ch.bfh.funkyCoders.taskList.service.impl;

import ch.bfh.funkyCoders.taskList.model.Person;
import ch.bfh.funkyCoders.taskList.repository.PersonRepository;
import ch.bfh.funkyCoders.taskList.service.PersonService;
import ch.bfh.funkyCoders.taskList.service.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Fanky on 25.11.14.
 */
public class DefaultPersonService implements PersonService {

    @Inject
    private PersonRepository personRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PersonDTO create(PersonDTO personDTO) {
        Person person = mapper.map(personDTO, Person.class);
        Person persistedPerson = personRepository.save(person);
        return mapper.map(persistedPerson, PersonDTO.class);
    }

    public PersonDTO read(long id) {
        Person person = personRepository.findOne(id);
        if (person == null) return null;
        return mapper.map(person, PersonDTO.class);
    }

    public Collection<PersonDTO> list() {
        Iterable<Person> persons = personRepository.findAll();
        Type listType = new TypeToken<Collection<PersonDTO>>() {}.getType();
        return mapper.map(persons, listType);
    }

    public PersonDTO update(PersonDTO personDTO) {
        Person person = mapper.map(personDTO, Person.class);
        Person updatedPerson = personRepository.save(person);
        return mapper.map(updatedPerson, PersonDTO.class);
    }

    public void delete(PersonDTO personDTO) {
        Person person = personRepository.findOne(personDTO.getId());
        personRepository.delete(person);
    }
}
