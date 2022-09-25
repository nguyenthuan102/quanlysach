package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "book_seq", initialValue = 1, allocationSize = 1)
public class Book {

	@Id
	@GeneratedValue(generator = "book_seq")
	private Long id;
	
	private String name;
	
	private String publishingHouse;
	
	@Column(name = "price", columnDefinition = "float8 default 0")
	private double price;
	
	@Column(name = "number_pages", columnDefinition = "int4 default 0")
	private int numberPages;
	
	private String author;
	
	
}
