package com.pandy.base.designpattern.iterator;

/**
 * @author Pandy
 * @date 2021/3/5 14:53
 */
public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < this.bookShelf.getLength();
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
