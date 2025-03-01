package com.example.userservice.controller;

import com.example.userservice.dto.SubscriptionDTO;
import com.example.userservice.model.Subscription;
import com.example.userservice.model.WebService;
import com.example.userservice.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public Subscription addSubscription(@PathVariable Long userId, @RequestParam String serviceName) {
        return subscriptionService.addSubscription(userId, serviceName);
    }

    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable Long userId, @PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(userId, subscriptionId);
    }

    @GetMapping
    public List<SubscriptionDTO> getSubscriptions(@PathVariable Long userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }

    @GetMapping("/top-services")
    public List<WebService> getTopServices() {
        return subscriptionService.getTopServices();
    }
}