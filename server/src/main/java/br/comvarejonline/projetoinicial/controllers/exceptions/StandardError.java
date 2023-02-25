package br.comvarejonline.projetoinicial.controllers.exceptions;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {
	private Instant timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timestamp, int status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}
