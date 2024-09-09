package com.leelamohan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelamohan.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

//    User findByUserName(String userName);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
