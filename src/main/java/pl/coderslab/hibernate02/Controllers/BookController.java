package pl.coderslab.hibernate02.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.hibernate02.Entitys.Author;
import pl.coderslab.hibernate02.Entitys.Book;
import pl.coderslab.hibernate02.Entitys.Publisher;
import pl.coderslab.hibernate02.Repositorys.AuthorDao;
import pl.coderslab.hibernate02.Repositorys.BookDao;
import pl.coderslab.hibernate02.Repositorys.BookRepository;
import pl.coderslab.hibernate02.Repositorys.PublisherDao;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @ModelAttribute("books")
    public Collection<Book> getBooks() {
        return bookDao.findAll();
    }

    @ModelAttribute("authors")
    public Collection<Author> getAuthors() {
        return authorDao.findAll();
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> getPublishers() {
        return publisherDao.findAll();
    }



    @RequestMapping(value ="/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute(book);
        return "addBookForm";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBookFrom(@Valid Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "addBookForm";
        } else {

            for (Author a : book.getAuthors()) {
                a.getBooks().add(book);
                authorDao.edit(a);
            }

            bookRepository.save(book);
            return "redirect:/booksIndex";
        }

    }


    @RequestMapping(value = "/booksIndex", method = RequestMethod.GET)
    public String booksIndex() {
        return "booksIndex";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);

        for (Author a : book.getAuthors()) {
            if (a.getBooks().contains(book)){
                a.getBooks().remove(book);
                authorDao.edit(a);
            }
            book.setAuthors(new HashSet<>());
            bookDao.edit(book);
        }

        return "editBookForm";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.POST)
    public String editBookFrom(@Valid Book book, BindingResult result){
        if (result.hasErrors()) {
            return "editBookForm";
        } else {

//            for (Author a : authorDao.findAll()) {
//                if ((a.getBooks().contains(book)) && (!book.getAuthors().contains(a))) {
//                    a.getBooks().remove(book);
//                    authorDao.edit(a);
//                }
//            }
            System.out.print(book.getAuthors().toString());

            for (Author a : book.getAuthors()) {
                if(!a.getBooks().contains(book)) {
                    a.getBooks().add(book);
                    authorDao.edit(a);
                }
            }

            bookRepository.save(book);
            return "redirect:/booksIndex";
        }
    }

    @RequestMapping(value = "/delateBook/{id}", method = RequestMethod.GET)
    public String delateBook(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "delateBook";
    }

    @RequestMapping("/delateBookTrue/{id}")
    public String delateTrue(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        for (Author a : book.getAuthors()) {
            a.getBooks().remove(book);
            authorDao.edit(a);
        }

        bookRepository.delete(book);
        return "redirect:/booksIndex";
    }

    @RequestMapping("/delateBookFalse")
    public String delateFalse() {
        return "redirect:booksIndex";
    }

}
