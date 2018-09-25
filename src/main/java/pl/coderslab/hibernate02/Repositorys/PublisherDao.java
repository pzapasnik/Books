package pl.coderslab.hibernate02.Repositorys;


import org.springframework.stereotype.Repository;
import pl.coderslab.hibernate02.Entitys.Publisher;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void edit(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(Long id) {

        return entityManager.find(Publisher.class, id);
    }

    public void delate(Publisher publisher) {

        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("select b from Publisher b");
        List<Publisher> publishers = query.getResultList();
        return publishers;
    }
}
