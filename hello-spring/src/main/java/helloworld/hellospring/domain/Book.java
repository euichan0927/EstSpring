package helloworld.hellospring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Book {
	private String id;
	private String name;
	private String author;
}
