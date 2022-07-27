package com.pandy.designpattern.iterator;

import java.util.Vector;

/**
 * @author Pandy
 * @date 2021/3/5 14:49
 */
public class BookShelf implements Aggregate {

    private final Vector<Book> books;
    //    private Book[] books;
    private final int last = 1;

    public BookShelf(int maxSize) {
        this.books = new Vector(maxSize);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
