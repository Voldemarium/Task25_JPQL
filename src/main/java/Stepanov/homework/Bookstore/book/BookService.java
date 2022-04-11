package Stepanov.homework.Bookstore.book;

import Stepanov.homework.Bookstore.entity.Book;
import Stepanov.homework.Bookstore.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "book")
    public Book getBookById(Long id) {
        return bookRepository.findBooksById(id) ;
    }

    @Cacheable(value = "book")
    public List<Book> getBooksByAuthorID(Long id) {
        return bookRepository.findAllByAuthor_Id(id);
    }
}
