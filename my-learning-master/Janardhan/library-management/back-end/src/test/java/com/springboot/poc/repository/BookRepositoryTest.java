package com.springboot.poc.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.poc.APIStarter;
import com.springboot.poc.configuration.DatabaseConfig;
import com.springboot.poc.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(classes = {APIStarter.class, DatabaseConfig.class})
@ComponentScan({"com.springboot.poc"})
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindAll() {
        
        Book book = new Book();
        
        book.setTitle("Angular");
        book.setIsbnNumber("1234");
        bookRepository.save(book);
        Iterable<Book> books = bookRepository.findAll();

        
    }

}
