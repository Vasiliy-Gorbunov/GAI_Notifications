package com.gai_app.gai_notifications.service;

import com.gai_app.gai_notifications.model.NotificationModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    List<NotificationModel> getAllNotifications();

    NotificationModel getNotificationById(Long id);

    NotificationModel createNotification(NotificationModel notification);

    List<NotificationModel> getAllNotificationsByUserId(Long userId);
}
