package com.functionalprogramming.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import com.functionalprogramming.Model.Book;
@Service
public class BookRepository {
    @Autowired
    private RedisTemplate template;
    public Book saveBook(Book book){
        System.out.print("Save in db ....");
      try {
        template.opsForHash().put("Book", String.valueOf(book.getId()), book);
      } catch (Exception e) {
       System.out.print(e.getCause()+" "+e.getMessage());
      }
      System.out.print("Done ........");
    return book;
    }
    public List<Book>bookList()
    { List<Book>getAll=template.opsForHash().values("Book");
        return getAll;
    }
    public Book findById(int id)
    {
        return (Book)template.opsForHash().get("Book",id);
    }
    public String deleteBook(int id)
    {
        template.opsForHash().delete("Book",id);
        return "Book removed";
    }
}
