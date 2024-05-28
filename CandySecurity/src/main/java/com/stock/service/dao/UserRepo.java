package com.stock.service.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Users;


public interface UserRepo extends JpaRepository<Users, Integer> {
Users findByUsername(String username);
}
