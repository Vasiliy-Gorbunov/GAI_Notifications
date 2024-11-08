package com.gai_app.gai_notifications.mapper;

import com.gai_app.gai_notifications.dto.NotificationDto;
import com.gai_app.gai_notifications.entity.Notification;
import com.gai_app.gai_notifications.model.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {


    @Autowired
    private NotificationMapper notificationMapper;
    
    public NotificationDto mapToNotificationDto(NotificationModel model) {
        return notificationMapper.toNotificationDto(model);
    }

    public NotificationModel mapToNotificationModelFromDto(NotificationDto dto) {
        return notificationMapper.toNotificationModelFromDto(dto);
    }

    public NotificationModel mapToNotificationModelFromEntity(Notification Notification) {
        return notificationMapper.toNotificationModelFromEntity(Notification);
    }

    public Notification mapToNotification(NotificationModel model) {
        return notificationMapper.toNotification(model);
    }
}
