package com.testapi.library.controller;

import com.testapi.library.entity.BookEntity;
import com.testapi.library.entity.ReserveInfo;
import com.testapi.library.exception.LibraryException;
import com.testapi.library.pojo.BookIssueRequest;
import com.testapi.library.requestobject.BookObject;
import com.testapi.library.response.Response;
import com.testapi.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "api/v1/book")
    public Response createBook(@RequestBody BookObject bookObject){
        String response = "";
        String message = "";
        int status = 0;
        try{
            String bookName = bookObject.getBookName();
            response = bookService.createBook(bookName);
            message =  "Book created successfully";
            status = 1;
        }
        catch (Exception e){
            message = "Error while creating Book";
        }
        return new Response(status, message, response);
    }

    @GetMapping(value = "api/v1/book")
    public Map<String, BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = "api/v1/reserve")
    public Map<String, ReserveInfo> getReserveBooksInfo(){
        return bookService.getReserveBooksInfo();
    }

    @GetMapping(value = "api/v1/book/{bookId}/check")
    public Response checkAvailabilty (@PathVariable("bookId") String bookId){
        try {
            Boolean response = bookService.checkAvailability(bookId);
            return new Response(1, "Success", response.toString());
        }
        catch (LibraryException e){
            return new Response(0,"Failed",e.getErrorMsg());
        }
    }

    @PostMapping(value = "api/v1/book/reserve")
    public Response Reserve(@RequestBody BookIssueRequest bookIssueRequest){
        try{
            Boolean isSuccess = bookService.reserve(bookIssueRequest.getUserId(),bookIssueRequest.getBookId());
            return new Response(1,"Success", isSuccess.toString());
        }
        catch (LibraryException ex)
        {
            return new Response(0, "Failed", ex.getErrorMsg());
        }
    }

    @PostMapping(value = "api/v1/book/unReserve")
    public Response unReserve(@RequestBody BookIssueRequest bookIssueRequest) {
        try {
            Boolean isSuccessful = bookService.unReserve(bookIssueRequest.getUserId(), bookIssueRequest.getBookId());
            return new Response(1, "Success", isSuccessful.toString());
        } catch (LibraryException ex) {
            return new Response(0, "Failed", ex.getErrorMsg());
        }

    }
    @PostMapping(value = "api/v1/book/issue")
    public Response issueBook(@RequestBody BookIssueRequest bookIssueRequest) {
        try {
            Boolean isSuccessful = bookService.issue(bookIssueRequest.getUserId(), bookIssueRequest.getBookId());
            return new Response(1, "Success", isSuccessful.toString());
        } catch (LibraryException ex) {
            return new Response(0, "Failed", ex.getErrorMsg());
        }

    }

    @PostMapping(value = "api/v1/book/return")
    public Response returnBook(@RequestBody BookIssueRequest bookIssueRequest) {
        try {
            Boolean isSuccessful = bookService.returnBook(bookIssueRequest.getUserId(), bookIssueRequest.getBookId());
            return new Response(1, "Success", isSuccessful.toString());
        } catch (LibraryException ex) {
            return new Response(0, "Failed", ex.getErrorMsg());
        }
    }
}
