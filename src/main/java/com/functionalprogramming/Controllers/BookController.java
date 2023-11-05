package com.functionalprogramming.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.functionalprogramming.Model.Book;
import com.functionalprogramming.Repository.BookRepository;

@Controller
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepository repository;
    @PostMapping(value="/save")
    public Book saveBook(@RequestBody Book book)
    {
        return repository.saveBook(book);
    }
    @GetMapping(value="/all")
   public List<Book>getAll()
   {
    return repository.bookList();
   }
}
