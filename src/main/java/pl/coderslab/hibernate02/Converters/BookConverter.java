package pl.coderslab.hibernate02.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.hibernate02.Entitys.Book;
import pl.coderslab.hibernate02.Repositorys.BookDao;

@Component
public class BookConverter implements Converter<String, Book> {

    @Autowired
    BookDao bookDao;

    @Override
    public Book convert(String s) {
        return bookDao.findById(Long.parseLong(s));
    }
}
