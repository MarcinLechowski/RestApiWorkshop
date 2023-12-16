package com.Kaer.BookRestApi.book;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book{

@Id
@SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
)

    @NonNull
    private Long id;
    @NonNull
    private String isbn;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String publisher;
    @NonNull
    private String type;

}
