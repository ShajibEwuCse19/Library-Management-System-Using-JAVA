package LMS;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Book {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private Date date;

    public Book(String id, String title, String author, String publisher, Date date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public Date getDate() {
        return this.date;
    }

    public void display() {
        System.out.println("Book Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Date: " + date);
        System.out.println();
    }
}
