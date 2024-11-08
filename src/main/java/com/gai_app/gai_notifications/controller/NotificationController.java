package com.gai_app.gai_notifications.controller;


import com.gai_app.gai_notifications.dto.NotificationDto;

import java.util.List;

public interface NotificationController {
    List<NotificationDto> getAllNotifications();
    List<NotificationDto> getNotificationsByUserId(Long userId);
    NotificationDto getNotificationById(Long id);
}
