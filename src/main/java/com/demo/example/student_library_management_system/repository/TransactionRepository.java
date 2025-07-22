package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT t.* FROM `transaction` t " +
            "JOIN book b ON t.book_id = b.id " +
            "WHERE DATEDIFF(CURDATE(), t.transaction_date) > 0 " +
            "AND t.is_issue_operation = 1 " +
            "AND b.issued_to_student = 1", nativeQuery = true)
    List<Transaction> findOverdueTransactions();

}
