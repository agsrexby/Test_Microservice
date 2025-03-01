package com.example.userservice.service;

import com.example.userservice.dto.SubscriptionDTO;
import com.example.userservice.model.Subscription;
import com.example.userservice.model.User;
import com.example.userservice.model.WebService;
import com.example.userservice.repository.ServiceRepository;
import com.example.userservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public Subscription addSubscription(Long userId, String serviceName) {
        // Находим или создаем сервис
        WebService service = serviceRepository.findByName(serviceName);
        if (service == null) {
            service = new WebService();
            service.setName(serviceName);
            serviceRepository.save(service);
        }

        // Создаем подписку
        Subscription subscription = new Subscription();
        subscription.setUser(new User(userId));
        subscription.setService(service);

        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Подписка не найдена"));

        if (!subscription.getUser().getId().equals(userId)) {
            throw new RuntimeException("Подписка не принадлежит указанному пользователю");
        }

        subscriptionRepository.delete(subscription);
    }
    public List<SubscriptionDTO> getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId).stream()
                .map(subscription -> new SubscriptionDTO(
                        subscription.getUser().getId(), // ID пользователя
                        subscription.getUser().getName(), // Имя пользователя
                        subscription.getService().getName())) // Название сервиса
                .collect(Collectors.toList());
    }

    public List<WebService> getTopServices() {
        return subscriptionRepository.findTopServices();
    }
}