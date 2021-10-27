package at.htl.control;

import at.htl.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.transaction.Transactional;
import java.util.List;

public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public void addEntity(Person person){
        this.getEntityManager().merge(person);
    }

    public List<Person> findAllPersons(){
        return findAll().list();
    }
}
