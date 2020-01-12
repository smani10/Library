package com.testapi.library.repository;

import com.testapi.library.entity.BookEntity;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BookRepo {
    private Map<String, BookEntity> books=new HashMap<>();

    public String addBook(String bookName){
        UUID uuid=UUID.randomUUID();
        BookEntity book=new BookEntity(uuid.toString(),bookName);
        books.put(uuid.toString(),book);
        return uuid.toString();
    }

    public Map<String, BookEntity> getAllBooks(){
        return books;
    }

    public boolean isBookAvailable(String bookId){
        return  books.get(bookId)!=null && books.get(bookId).isAvailable();
    }

    public void makeBookUnavailable(String bookId){
        BookEntity bookEntity = books.get(bookId);
        bookEntity.setAvailable(false);
    }

    public void makeBookAvailable(String bookId){
        BookEntity bookEntity = books.get(bookId);
        bookEntity.setAvailable(true);
    }
}
