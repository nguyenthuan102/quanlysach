package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.ResponseObject;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<ResponseObject> getBook() {
		ResponseObject response = bookService.get();
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/{id}/xx", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<ResponseObject> getDetailBook(@PathVariable(name = "id") Long id) {
		ResponseObject response = bookService.getDetailBook(id);
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	private ResponseEntity<ResponseObject> createBook(@RequestBody BookDTO bookDTO) {
		ResponseObject response = bookService.create(bookDTO);
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	private ResponseEntity<ResponseObject> updateBook(@RequestBody BookDTO bookDTO) {
		ResponseObject response = bookService.update(bookDTO);
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	private ResponseEntity<ResponseObject> deleteBook(@PathVariable(name = "id") Long id) {
		ResponseObject response = bookService.delete(id);
		return ResponseEntity.ok(response);
	}
}
