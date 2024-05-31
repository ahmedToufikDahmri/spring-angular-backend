package com.etm.tp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class NotFond extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotFond(String message) {
		super(message);
	}
}
