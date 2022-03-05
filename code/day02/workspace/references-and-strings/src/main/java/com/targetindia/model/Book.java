package com.targetindia.model;

public class Book {
    // private members can be accessed inside any method that belongs to this class
    private int id;
    private String title;
    private String author;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        // this being a function, can check the validity of inputs and assign only if the inputs are valid

        if(id<=0){
            throw new RuntimeException("Id cannot be <= 0");
        }

        this.id = id; // when this method is invoked using "b1" in the main, "this" is same as "b1"
        // the "this" keyword is used only to differentiate between a local variable and the member variable
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
//        return "Book (" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ')';

        return String.format("Book (id=%s, title=\"%s\", author=\"%s\")", id, title, author);
    }
}
