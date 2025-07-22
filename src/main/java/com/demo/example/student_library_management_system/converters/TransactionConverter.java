package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.dto.TransactionRequestDto;
import com.demo.example.student_library_management_system.model.Transaction;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction=Transaction.builder().transactionStatus(transactionRequestDto.getTransactionStatus())
                .isIssueOperation(transactionRequestDto.isIssueOperation())
                .fine(transactionRequestDto.getFine()).build();
        return transaction;
    }
}
