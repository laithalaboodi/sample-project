package com.laith.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laith.app.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	public User findByEmail(String email);
	public User findById(int id);

}
