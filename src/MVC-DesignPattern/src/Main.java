import Controller.BookController;
import Model.Book;
import View.BookView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        BookView view = new BookView();

        BookController controller = new BookController(books, view);

        controller.addBook(new Book(1, "1984", "George Orwell"));
        controller.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));

        controller.updateView();

        controller.updateBook(1, "Animal Farm", "George Orwell");

        controller.removeBook(2);

        controller.updateView();
    }
}