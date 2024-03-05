package helloworld.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import helloworld.hellospring.domain.Book;
@Repository
public class BookRepository {
	private Map<String, Book> bookMap;
	public BookRepository() {

		bookMap = new HashMap<>();
		Book book1 = new Book("2", "오늘도 개발자가 안된다고 말했다.", "김김김");
		Book book2 = new Book("3", "객체지향의 꽃", "박박박");

		bookMap.put(book1.getId(), book1);
		bookMap.put(book2.getId(),book2);
	}
	public List<Book> getAllBooks(){
		List<Book> bookList = new ArrayList<>();
		for(Map.Entry<String,Book> book :bookMap.entrySet()){
			bookList.add(book.getValue());
		}
		return bookList;
	}
	public void addBook(Book book){
		bookMap.put(book.getId(),book);
	}
	public Book getBook(String id){
		for(Map.Entry<String,Book> book : bookMap.entrySet()){
			if(book.getKey().equals(id)){
				return book.getValue();
			}
		}
		return null;
	}
}
