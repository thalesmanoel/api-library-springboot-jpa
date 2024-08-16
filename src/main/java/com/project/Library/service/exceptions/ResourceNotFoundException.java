package com.project.Library.service.exceptions;


public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Resource not found. ID: " + id);
	}
}
