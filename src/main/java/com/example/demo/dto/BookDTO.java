package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	private Long id;
	
	private String name;
	
	private String publishingHouse;

	private double price;

	private int numberPages;

	private String author;
}
