package com.example.api.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
}
