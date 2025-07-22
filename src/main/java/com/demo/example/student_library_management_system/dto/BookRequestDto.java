package com.demo.example.student_library_management_system.dto;

import com.demo.example.student_library_management_system.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookRequestDto {

    private String name;
    private Genre genre;
    private int pages;
    private String publisherName;
    private boolean issuedToStudent;
    private int authorId;
    private int cardId;
}
