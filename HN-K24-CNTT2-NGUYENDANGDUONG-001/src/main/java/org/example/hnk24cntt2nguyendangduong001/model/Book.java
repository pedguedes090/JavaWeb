package org.example.hnk24cntt2nguyendangduong001.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
public class Book {
    @NotNull(message = "ID không được để trống")
    @Positive(message = "ID phải là số nguyên dương")
    private Long id;

    @NotBlank(message = "Title không được để trống")
    @Size(min = 3, max = 100, message = "Title phải có độ dài từ 3 đến 100 ký tự")
    private String title;
    @NotBlank(message = "Author không được để trống")
    private String author;
    @NotNull(message = "Quantity không được để trống")
    @Min(value = 1, message = "Quantity phải là số nguyên lớn hơn 0")
    private Integer quantity;
    private String coverImage;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer quantity, String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
