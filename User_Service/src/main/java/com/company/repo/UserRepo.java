package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.User;

public interface UserRepo extends JpaRepository<User,Long>{

}
