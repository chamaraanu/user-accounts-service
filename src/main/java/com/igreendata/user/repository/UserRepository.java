package com.igreendata.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.igreendata.user.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findUserIdByUsername(String username);
	
	User findUserByUsername(String username);
	
	List<User> findAll();

}
