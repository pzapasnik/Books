package pl.coderslab.hibernate02.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.hibernate02.Entitys.Author;
import pl.coderslab.hibernate02.Repositorys.AuthorDao;


@Component
public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        Author author = authorDao.findById(Long.parseLong(s));
        return author;
    }
}
