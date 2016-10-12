package io.bitzl.test.tostringwithyaml;


import org.joda.time.DateTime;

import static io.bitzl.test.tostringwithyaml.ToString.stringRepresentationOf;

public class Book {


    private String title;

    private Person author;

    private DateTime publishedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public DateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(DateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return stringRepresentationOf(this);
    }

}
