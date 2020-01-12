package com.testapi.library.service;

import com.testapi.library.entity.BookEntity;
import com.testapi.library.entity.ReserveInfo;
import com.testapi.library.repository.BookRepo;
import com.testapi.library.repository.IssueInfoRepo;
import com.testapi.library.repository.ReserveInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ReserveInfoRepo reserveInfoRepo;

    @Autowired
    private IssueInfoRepo issueInfoRepo;

    public String createBook(String bookName){
        return bookRepo.addBook(bookName);
    }

    public Map<String, BookEntity> getAllBooks(){
        return bookRepo.getAllBooks();
    }

    public boolean checkAvailability(String bookId){
        return bookRepo.isBookAvailable(bookId);
    }

    public boolean reserve(String userId, String bookId){
        return reserveInfoRepo.reserve(userId,bookId);
    }

    public Map<String, ReserveInfo> getReserveBooksInfo(){
        return reserveInfoRepo.getReserveBooksInfo();
    }


    public boolean unReserve(String userId,String bookId){
        return reserveInfoRepo.unReserve(userId,bookId);
    }

    public boolean issue(String userId, String bookId) {
        return issueInfoRepo.issue(userId, bookId);
    }

    public boolean returnBook(String userId, String bookId) {

        return issueInfoRepo.returnBook(userId, bookId);
    }

}
