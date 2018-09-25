package pl.coderslab.hibernate02.Repositorys;

import org.springframework.stereotype.Repository;
import pl.coderslab.hibernate02.Entitys.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Book book) {
        entityManager.persist(book);
    }

    public void edit(Book book) {
        entityManager.merge(book);
    }

    public Book findById(Long id) {

        return entityManager.find(Book.class, id);
    }

    public void delate(Book book) {

        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select b from Book b");
        List<Book> books = query.getResultList();
        return books;
    }

    public List<Book> getRatingList(Double rating) {
        Query query = entityManager.createQuery("select b from Book b where rating =:rating");
        query.setParameter("rating", rating);
        List<Book> books = query.getResultList();
        return books;
    }
}
