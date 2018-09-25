package pl.coderslab.hibernate02.Repositorys;


import org.springframework.stereotype.Repository;
import pl.coderslab.hibernate02.Entitys.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao  {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void edit(Author author) {
        entityManager.merge(author);
    }

    public Author findById(Long id) {

        return entityManager.find(Author.class, id);
    }

    public void delate(Author author) {

        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select b from Author b");
        List<Author> authors = query.getResultList();
        return authors;
    }
}

