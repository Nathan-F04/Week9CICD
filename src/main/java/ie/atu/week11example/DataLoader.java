package ie.atu.week11example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert data here
        Person testData1 = new Person(1L, "Paul",23 , "paul@atu.ie","Mr", "12345", "Lecturer", "Electronics");
        Person testData2 = new Person(2L, "Nathan",20 , "nathan@atu.ie","Mr", "12346", "Student", "Electronics");
        Person testData3 = new Person(3L, "Shine",20 , "shine@atu.ie","Mr", "12347", "Student", "Electronics");
        personRepository.save(testData1);
        personRepository.save(testData2);
        personRepository.save(testData3);
    }
}
