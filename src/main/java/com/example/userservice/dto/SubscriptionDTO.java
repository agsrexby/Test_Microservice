package com.example.userservice.dto;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {
    private Long userId; // ID пользователя
    private String userName; // Имя пользователя
    private String serviceName; // Название сервиса
}
