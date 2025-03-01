package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_id")
    private WebService service;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "app_user")
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WebService getService() {
        return service;
    }

    public void setService(WebService service) {
        this.service = service;
    }

    public User getUser() {
        return user;
    }
}