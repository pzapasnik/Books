package pl.coderslab.hibernate02.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.hibernate02.Entitys.Author;
import pl.coderslab.hibernate02.Entitys.Book;
import pl.coderslab.hibernate02.Repositorys.AuthorDao;
import pl.coderslab.hibernate02.Repositorys.AuthorRepository;
import pl.coderslab.hibernate02.Repositorys.BookDao;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookDao bookDao;

    @ModelAttribute("authors")
    public Collection<Author> showAllAuthors() {
            return authorDao.findAll();
        }
    @ModelAttribute("books")
    public Collection<Book> showAllBooks() {
        return bookDao.findAll();
    }

    @RequestMapping(value = "/authorsIndex", method = RequestMethod.GET)
    public String autrhorsIndex(){
        return "authorsIndex";
    }


    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public String addAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "addAuthorForm";
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public String addAuthorForm(@Valid Author author, BindingResult result){
        if (result.hasErrors()) {
            return "addAuthorForm";
        } else {

            authorDao.save(author);
            return "redirect:/authorsIndex";
        }
    }

    @RequestMapping(value = "/editAuthor/{id}", method = RequestMethod.GET)
    public String editAuthor(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "editAuthorForm";
    }

    @RequestMapping(value = "/editAuthor/{id}", method = RequestMethod.POST)
    public String editAuthorForm(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "editAuthorForm";
        } else {
            authorDao.edit(author);
            return "redirect:/authorsIndex";
        }
    }

    @RequestMapping("/delateAuthor/{id}")
    public String delateA(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "delateAuthor";
    }

    @RequestMapping("/delateAuthorTrue/{id}")
    public String delateATrue(@PathVariable Long id){
        authorDao.delate(authorDao.findById(id));
        return"redirect:/authorsIndex";
    }

    @RequestMapping("/delateAurhorFalse")
    public String delateAFalse() { return "redirect:/authorIndex";}


}

