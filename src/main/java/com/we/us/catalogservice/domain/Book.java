package com.we.us.catalogservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class Book {
    @NotBlank(message = "ISBN  cannot be blank.")
    private String isbn;
    @NotBlank(message = "Book name cannot be blank.")
    private String name;
    @NotBlank(message = "Author cannot be blank.")
    private String author;
    @NotNull(message = "Price cannot be blank.")
    @Positive(message = "Price must be greater than zero.")
    private Double price;
}
