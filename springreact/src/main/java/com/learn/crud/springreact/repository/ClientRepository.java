package com.learn.crud.springreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.crud.springreact.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
}