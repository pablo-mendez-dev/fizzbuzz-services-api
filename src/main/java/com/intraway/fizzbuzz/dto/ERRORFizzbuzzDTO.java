package com.intraway.fizzbuzz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto DTO utilizado en la respuesta de una invocacion con request incorrecto
 * @author Pablo Mendez
 *
 */
@Getter
@Setter
@ToString
public class ERRORFizzbuzzDTO {

	@JsonProperty("timestamp")
	private String timestamp;
	@JsonProperty("status")
	private int status;
	@JsonProperty("error")
	private String error;
	@JsonProperty("exception")
	private String exception;
	@JsonProperty("message")
	private String message;
	@JsonProperty("path")
	private String path;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
