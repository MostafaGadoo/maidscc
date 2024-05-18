package com.example.maidscc.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class BookModel {
    private long bookId;
    private String bookTitle;
    private String bookAuthor;
    private LocalDate publicationYear;
    private String ISBN;
}
