package Controller;

import Model.Book;
import View.BookView;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private List<Book> books;
    private BookView view;

    public BookController(List<Book> books, BookView view) {
        this.books = books;
        this.view = view;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, String title, String author) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                break;
            }
        }
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void updateView() {
        view.printBookDetails(books);
    }
}
