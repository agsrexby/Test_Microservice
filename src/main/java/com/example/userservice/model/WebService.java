package com.example.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "web_service")
public class WebService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
}
