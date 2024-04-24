package day11;

import java.util.*;

class Book implements Comparable<Book>{
    @Override
    public int compareTo(Book o) {
        return o.year-this.year;
    }

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return title + " , " + author + " / " + year;
    }
}

class BookManager {
    ArrayList<Book> books = new ArrayList<>();
    public void addBook (Book book) {
       if (books.contains(book)) {
           System.out.println(book + " 은 중복된 책 입니다.");
       }else {
           books.add(book);
       }
    }
    public void displayBooks() {
        System.out.println(books);
    }
    public void sortBooksByYear(){
        Collections.sort(books);
        Collections.reverse(books);
    }
    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)){
                System.out.println(book);
            }
        }
    }
    public void removeBookByTitle (String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)){
                iterator.remove();
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("모두의 자바", "강경미", 2015));
        manager.addBook(new Book("이것이 자바다", "신용권", 2018));
        manager.addBook(new Book("자바의 정석", "남궁성", 2013));

        manager.displayBooks();
        manager.removeBookByTitle("자바의 정석");
        manager.displayBooks();

    }
}