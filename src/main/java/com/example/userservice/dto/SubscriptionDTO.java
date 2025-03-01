package com.example.userservice.dto;

import lombok.Data;

@Data
public class SubscriptionDTO {
    private Long userId; // ID пользователя
    private String userName; // Имя пользователя
    private String serviceName; // Название сервиса

    public SubscriptionDTO(Long userId, String userName, String serviceName) {
        this.userId = userId;
        this.userName = userName;
        this.serviceName = serviceName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}