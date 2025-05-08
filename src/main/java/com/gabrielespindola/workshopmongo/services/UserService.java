package com.gabrielespindola.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielespindola.workshopmongo.domain.User;
import com.gabrielespindola.workshopmongo.dto.UserDTO;
import com.gabrielespindola.workshopmongo.repository.UserRepository;
import com.gabrielespindola.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDtO) {
		return new User(objDtO.getId(), objDtO.getName(), objDtO.getEmail());
	}

}
