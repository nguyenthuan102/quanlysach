package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.ResponseObject;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public ResponseObject get() {
		List<BookDTO> bookDTOs = new ArrayList<>();
		List<Book> list = bookRepository.findAll();
		list.forEach(book -> {
			bookDTOs.add(BookDTO.builder().id(book.getId()).name(book.getName()).author(book.getAuthor())
					.publishingHouse(book.getPublishingHouse()).numberPages(book.getNumberPages())
					.price(book.getPrice()).build());
		});
		return new ResponseObject(200, "ok", bookDTOs);
	}

	public ResponseObject getDetailBook(Long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (!bookOptional.isPresent()) {
			return new ResponseObject(404, "book not found");
		}
		Book book = bookOptional.get();
		return new ResponseObject(200, "ok",
				BookDTO.builder().id(book.getId()).name(book.getName()).author(book.getAuthor())
						.publishingHouse(book.getPublishingHouse()).numberPages(book.getNumberPages())
						.price(book.getPrice()).build());
	}

	public ResponseObject create(BookDTO bookDTO) {
		Book book = Book.builder().name(bookDTO.getName()).author(bookDTO.getAuthor())
				.publishingHouse(bookDTO.getPublishingHouse()).numberPages(bookDTO.getNumberPages()).price(bookDTO.getPrice())
				.build();
		book = bookRepository.save(book);
		bookDTO.setId(book.getId());
		return new ResponseObject(200, "ok", bookDTO);
	}

	public ResponseObject update(BookDTO bookDTO) {
		Optional<Book> bookOptional = bookRepository.findById(bookDTO.getId());
		if (!bookOptional.isPresent()) {
			return new ResponseObject(404, "book not found");
		}
		Book book = bookOptional.get();
		book.setName(bookDTO.getName());
		bookRepository.save(book);
		return new ResponseObject(200, "ok", bookDTO);
	}

	public ResponseObject delete(Long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (!bookOptional.isPresent()) {
			return new ResponseObject(404, "book not found");
		}
		bookRepository.delete(bookOptional.get());
		return new ResponseObject(200, "ok");
	}
}
