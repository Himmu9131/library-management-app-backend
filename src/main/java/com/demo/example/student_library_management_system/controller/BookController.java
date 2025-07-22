package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.dto.BookRequestDto;
import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.service.BookService;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response = bookService.addBook(bookRequestDto);
        return response;
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> getAll(){
        try {
            List<Book> bookList = bookService.getAll();
            return ResponseEntity.ok().body(bookList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{bookid}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("bookid") int bookId){
        try {
            String response = bookService.deleteBookById(bookId);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/totalBooks")
    public long totalBooks(){
        try {
            long totalBooks = bookService.countBooks();
            return totalBooks;
        }
        catch(Exception e){
            throw new UnsupportedOperationException();
        }
    }

    @GetMapping("/borrowedBooks")
    public long totalBorrowed(){
        try{
            long totalBorrowed = bookService.borrowedBooks();
            return totalBorrowed;
        }catch(Exception e){
           throw new NoSuchElementException();
        }
    }

    @GetMapping("/totalBorrowers")
    public ResponseEntity<Integer> totalBorrowers() {
        try {
            int totalBorrowers = bookService.totalBorrower(); // Already an int
            System.out.println("totalBorrowers() called");
            return ResponseEntity.ok(totalBorrowers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
        }
    }
    }



