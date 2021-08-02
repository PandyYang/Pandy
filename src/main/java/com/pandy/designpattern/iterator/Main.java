package com.pandy.designpattern.iterator;

/**
 * @author Pandy
 * @date 2021/3/5 14:57
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(1);
        bookShelf.appendBook(new Book("乞力马扎罗的雪"));
        bookShelf.appendBook(new Book("老人与海"));
        bookShelf.appendBook(new Book("丧钟为谁耳鸣"));
        bookShelf.appendBook(new Book("源氏物语"));
        bookShelf.appendBook(new Book("源氏物语"));
        bookShelf.appendBook(new Book("源氏物语"));
        bookShelf.appendBook(new Book("源氏物语"));
        bookShelf.appendBook(new Book("源氏物语"));
        bookShelf.appendBook(new Book("源氏物语"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book =  (Book)iterator.next();
            System.out.println(book.getName());
        }
    }
}
