package com.example.userservice.repository;

import com.example.userservice.model.WebService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<WebService, Long> {
    WebService findByName(String name);
}