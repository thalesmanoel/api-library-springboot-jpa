package com.project.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.Library.entities.Books;
import com.project.Library.repository.BooksRepository;
import com.project.Library.service.exceptions.ResourceNotFoundException;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Books> listBooks(){
		return booksRepository.findAll();
		}
	
	 public Books findBooksById(Long id) {
		 	Optional<Books> obj = booksRepository.findById(id);
			return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	    }

	    public Books saveBooks(Books books) {
	        return booksRepository.save(books);
	    }

	    public void deleteBooks(Long id) {
	    	try {
				booksRepository.deleteById(id);
			} catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			}
	    }

	    public Books updateBooks(Long id, Books booksUpdated) {
	        Optional<Books> booksOpt = booksRepository.findById(id);
	        
	        
	        if (booksOpt.isPresent()) {
	            Books books = booksOpt.get();
	            
	            books.setName(booksUpdated.getName());
	            books.setAuthor(booksUpdated.getAuthor());
	            books.setPrice(booksUpdated.getPrice());
	            books.setQuantity(booksUpdated.getQuantity());
	            
	            return booksRepository.save(books);
	        }
	        else 
	        {
	        	throw new ResourceNotFoundException(id);
	        }
	    }
}
