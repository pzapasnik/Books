package pl.coderslab.hibernate02.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.hibernate02.Entitys.Author;
import pl.coderslab.hibernate02.Entitys.Book;
import pl.coderslab.hibernate02.Entitys.Publisher;
import pl.coderslab.hibernate02.Repositorys.BookDao;
import pl.coderslab.hibernate02.Repositorys.BookRepository;
import pl.coderslab.hibernate02.Repositorys.PublisherDao;
import pl.coderslab.hibernate02.Repositorys.PublisherRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    BookDao bookDao;

    @ModelAttribute("allPublishers")
    public Collection<Publisher> showPublishers() { return publisherDao.findAll();}

    @RequestMapping("/publishersIndex")
    public String allPublishers() { return "publishersIndex"; }

    @RequestMapping(value = "/addPublisher", method = RequestMethod.GET)
    public String addPublisher(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "addPublisherForm";
    }

    @RequestMapping(value = "/addPublisher", method = RequestMethod.POST)
    public String addPublisherForm(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "addPublisherForm";

        } else {

            publisherRepository.save(publisher);
            return "redirect:/publishersIndex";
        }
    }

    @RequestMapping(value = "/editPublisher/{id}", method = RequestMethod.GET)
    public String editPublisher(@PathVariable Long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "editPublisherForm";
    }

    @RequestMapping(value = "/editPublisher/{id}", method = RequestMethod.POST)
    public String editPublisherFrom(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "editPublisherForm";

        } else {

            publisherRepository.save(publisher);
            return "redirect:/publishersIndex";
        }
    }

    @RequestMapping(value = "/delatePublisher/{id}", method = RequestMethod.GET)
    public String delatePublisher(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "delatePublisher";
    }

    @RequestMapping(value = "/delatePublisherTrue/{id}")
    public String delatePublisherTrue(@PathVariable Long id){
        Publisher p = publisherDao.findById(id);
        for (Book b : p.getBooks()) {
            b.setPublisher(null);
            bookRepository.save(b);
        }
        publisherRepository.delete(p);
        return "redirect:/publishersIndex";
    }

    @RequestMapping("/delatePublisherFalse")
    public String delatePublisherFalse() { return "redirect:/publishersIndex";}


}

