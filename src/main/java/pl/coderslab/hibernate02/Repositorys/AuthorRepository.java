package pl.coderslab.hibernate02.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.hibernate02.Entitys.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository <Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);

//    Zad 2

    @Query("select a from Author a where a.email like ?1%")
    List<Author> findAllAuthorsWhereEmailStartsWith(String email);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> findAllAuthorsWherePeselStartsWith(int pesel);



}
