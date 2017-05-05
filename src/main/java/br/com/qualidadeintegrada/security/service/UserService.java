package br.com.qualidadeintegrada.security.service;

import br.com.qualidadeintegrada.security.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	public void saveUser(User user);

}
