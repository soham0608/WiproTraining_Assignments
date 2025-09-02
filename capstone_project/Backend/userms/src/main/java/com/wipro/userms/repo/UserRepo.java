package com.wipro.userms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.userms.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserIdAndPassWord(String userId,String passWord);
	User findByUserId(String userName);
}