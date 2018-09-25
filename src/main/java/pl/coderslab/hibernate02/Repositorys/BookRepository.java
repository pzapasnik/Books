package pl.coderslab.hibernate02.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.hibernate02.Entitys.Author;
import pl.coderslab.hibernate02.Entitys.Book;
import pl.coderslab.hibernate02.Entitys.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findFirstByTitle(String title);

    List<Book> findAllByTitle(String title);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByPublisherId(Long id);

    List<Book> findAllByAuthors(Author author);

    List<Book> findAllByRating(Double rating);

    Book findFirstByPublisherOrderByTitle(Publisher publisher);


    @Query("select b from Book b where b.title = ?1")
    List<Book> findAllBooksByTitle(String title);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> findAllByRatingBetween(int one, int second);

    @Query("select b from Book b where b.publisher = ?1")
    List <Book> findBooksByPublisher(Publisher publisher);

    @Query("select b from Book b where b.publisher = ?1 order by b.title")
    Book findBookByPublisherSortByTitle(Publisher publisher);




}
