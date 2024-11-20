package ie.atu.week11example;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // Placeholder method to save a person (add to Db in the next two weeks)
    public void savePerson(Person person) {
        personRepository.save(person);
        System.out.println("Person saved: " + person);
    }

    // Placeholder method to retrieve a person by employeeId
    public Person getPersonByEmployeeId(String employeeId) {
        // fetch data from a database in future lab
        // For simplicity, we return a dummy person here
        return personRepository.findByEmployeeId(employeeId);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public void updatePerson(String email, Person updatedPerson){
        Optional<Person> existingPersonOptional = personRepository.findByEmail(email);

        if(existingPersonOptional.isPresent()){
            Person existingPerson = existingPersonOptional.get();

            //Update class fields with new data
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setAge(updatedPerson.getAge());
            existingPerson.setEmail(updatedPerson.getEmail());
            existingPerson.setTitle(updatedPerson.getTitle());
            existingPerson.setEmployeeId(updatedPerson.getEmployeeId());
            existingPerson.setPosition(updatedPerson.getPosition());
            existingPerson.setDepartment(updatedPerson.getDepartment());
            personRepository.save(existingPerson);
        }else{
            //handle not found scenario
        }
    }
}
