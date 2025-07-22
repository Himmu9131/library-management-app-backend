package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT COUNT(b) from Book b where b.issuedToStudent=true")
    int countBorrowedBooks();
    @Query(value = "SELECT COUNT(DISTINCT card_id) FROM book WHERE issued_to_student = true", nativeQuery = true)
    int totalBorrowers();
}
