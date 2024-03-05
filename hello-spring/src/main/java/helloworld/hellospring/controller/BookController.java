package helloworld.hellospring.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import helloworld.hellospring.domain.Book;
import helloworld.hellospring.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j	//로그 사용
@Controller
public class BookController {
	private final BookRepository bookRepository;
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/books")
	public String getBooks(Model model){
		// Book book = new Book("1","김의찬","Spring핵심개념");
		// model.addAttribute("bookList",List.of(book));
		List<Book> bookList = bookRepository.getAllBooks();
		model.addAttribute("bookList",bookList);
		return "bookManager";
	}

	@PostMapping("/books")
	public String saveBook(@RequestParam String id, @RequestParam String name, @RequestParam String author, Model model){
		Book book = Book.builder().id(id).name(name).author(author).build();
		bookRepository.addBook(book);
		return "redirect:/books";
	}
	@GetMapping("/books/{id}")
	public String detail(@PathVariable("id") String id,Model model){
		model.addAttribute("book",bookRepository.getBook(id));
		log.info("id = "+ id);
		return "bookDetail";
	}
}
