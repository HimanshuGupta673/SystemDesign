package View;

import Model.Book;

import java.util.List;

public class BookView {
    public void printBookDetails(List<Book> books) {
        for (Book book : books) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println();
        }
    }
}
