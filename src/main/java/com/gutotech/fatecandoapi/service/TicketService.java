package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Ticket;
import com.gutotech.fatecandoapi.repository.TicketRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	public List<Ticket> findAll() {
		return repository.findAll();
	}

	public List<Ticket> findByUser(String email) {
		return repository.findByUser_email(email);
	}

	public Ticket findById(Long id) {
		return repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Could not find ticket " + id));
	}

	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
