package com.we.us.catalogservice;

import com.we.us.catalogservice.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	@Test
	void testPostRequest() {
		Book book = new Book("123", "Hello World", "Praneet", 9.90);
		webTestClient.post()
				.uri("/books")
				.bodyValue(book)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Book.class).value(savedBook ->{
					Assertions.assertThat(savedBook).isNull();
					Assertions.assertThat(savedBook.getIsbn()).isEqualTo(book.getIsbn());
				});
	}

}
