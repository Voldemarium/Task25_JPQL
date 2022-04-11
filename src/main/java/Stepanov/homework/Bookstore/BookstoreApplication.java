package Stepanov.homework.Bookstore;

import Stepanov.homework.Bookstore.author.AuthorService;
import Stepanov.homework.Bookstore.book.BookService;
import Stepanov.homework.Bookstore.bookWarehouse.BookWarehouseService;
import Stepanov.homework.Bookstore.buyer.BuyerService;
import Stepanov.homework.Bookstore.entity.*;
import Stepanov.homework.Bookstore.ordering.OrderService;
import Stepanov.homework.Bookstore.ordering_details.OrderingDetailsService;
import Stepanov.homework.Bookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDate;

@SpringBootApplication
@EnableCaching
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookstoreApplication.class, args);

        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);
        BookWarehouseService bookWarehouseService = context.getBean(BookWarehouseService.class);
        BuyerService buyerService = context.getBean(BuyerService.class);
        OrderService orderService = context.getBean(OrderService.class);
        OrderingDetailsService orderingDetailsService = context.getBean(OrderingDetailsService.class);

        //   authorService.createAuthor(new Author("Petrov", "Ivan", "Ivanovich")); //"Ivanov", "Ivan", "Ivanovich"

        //   bookService.createBook(new Book("Spring", authorService.getAuthorById(3L), 2005, 240, 700));

        //  bookWarehouseService.createBookWarehouse(new BookWarehouse(bookService.getBookById(17L), 4));

        //   buyerService.createBuyer(new Buyer("Kozlov", "Vlad", "Ivanovich", LocalDate.of(1999, 1, 1)));

//        log.info("Authors: {}", authorService.getAuthors());
//        log.info("Books: {}", bookService.getBooks());

        BookRepository bookRepository = context.getBean(BookRepository.class);
        log.info("Search result books with the author_id 3: {}", bookService.getBooksByAuthorID(3L));

        log.info("Search result books with the author Kozlov Vlad Ivanovich: {}",
                bookRepository.findAllByAuthor_SurnameAndAuthor_NameAndAuthor_Middle_name(
                        "Kozlov", "Vlad", "Ivanovich"
                )
        );
    }
}
