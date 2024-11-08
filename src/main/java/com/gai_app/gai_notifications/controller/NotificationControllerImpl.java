package com.gai_app.gai_notifications.controller;

import com.gai_app.gai_notifications.dto.NotificationDto;
import com.gai_app.gai_notifications.mapper.MappingUtils;
import com.gai_app.gai_notifications.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationControllerImpl implements NotificationController {

    private final NotificationService notificationService;
    private final MappingUtils mappingUtils;

    public NotificationControllerImpl(NotificationService notificationService, MappingUtils mappingUtils) {
        this.notificationService = notificationService;
        this.mappingUtils = mappingUtils;
    }

    @GetMapping
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications().stream()
                .map(mappingUtils::mapToNotificationDto).toList();
    }

    @GetMapping("/user/{id}")
    public List<NotificationDto> getNotificationsByUserId(@PathVariable Long id) {
        return notificationService.getAllNotificationsByUserId(id).stream()
                .map(mappingUtils::mapToNotificationDto).toList();
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable Long id) {
        return mappingUtils.mapToNotificationDto(notificationService.getNotificationById(id));
    }
}
