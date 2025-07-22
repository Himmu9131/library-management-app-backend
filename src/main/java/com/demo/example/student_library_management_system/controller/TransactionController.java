package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.dto.TransactionRequestDto;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.service.StudentService;
import com.demo.example.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response = transactionService.addTransaction(transactionRequestDto);
        return response;
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> getAllTransactions(){
        try {
            List<Transaction> transactionList = transactionService.getAll();
            return ResponseEntity.ok().body(transactionList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/overdueTransactions")
    public ResponseEntity<?> overdueTransactions(){
        try {
            int overdue = transactionService.overDueTransactions().size();
            return ResponseEntity.ok(overdue);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(0);
        }
    }
}
