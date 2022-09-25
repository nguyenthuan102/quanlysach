package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
	private int status;
	private String msg;
	private Object data;

	public ResponseObject(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
}
