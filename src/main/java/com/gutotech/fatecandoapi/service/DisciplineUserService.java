package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.DisciplineUser;
import com.gutotech.fatecandoapi.model.DisciplineUserId;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.DisciplineUserRepository;

@Service
public class DisciplineUserService {

	@Autowired
	private DisciplineUserRepository repository;

	public List<DisciplineUser> findAll() {
		return repository.findAll();
	}

	public DisciplineUser findById(Discipline discipline, User user) {
		DisciplineUserId id = new DisciplineUserId(discipline, user);
		return repository.findById(id).orElse(new DisciplineUser(id, null, false));
	}

	public DisciplineUser save(DisciplineUser disciplineUser) {
		return repository.save(disciplineUser);
	}

}
