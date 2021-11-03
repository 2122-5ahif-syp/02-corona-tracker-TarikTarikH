package at.htl.control;

import at.htl.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public Person addEntity(Person person){
        return this.getEntityManager().merge(person);
    }

    public List<Person> findAllPersons(){
        return findAll().list();
    }
}
