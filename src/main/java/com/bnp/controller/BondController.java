package com.bnp.controller;

import com.bnp.data.Bond;
import com.bnp.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

/**
 * Simple REST controller for accessing application logic.
 */
@RestController
public class BondController {

	private final BondRepository repository;

	@Autowired
	public BondController(BondRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/bond/list")
	public Iterable<Bond> bonds() {
		return repository.findAll();
	}

	@GetMapping("/bond/show/{id}")
	public Optional<Bond> show(@PathVariable(value = "id") Long id) {
		return repository.findById(id);
	}

	@GetMapping("/bond/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		repository.deleteById(id);
	}

	@PostMapping("/bond/save")
	public void save(@RequestBody Bond bond) {
		repository.save(bond);
	}

	@PostMapping("/bond/update")
	public void update(@RequestBody Bond bond) {
		repository.save(bond);
	}

	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")
	@ExceptionHandler({ Exception.class})
	public String handleException(RuntimeException ex, WebRequest request) {
		return ex.getMessage();
	}

}
