package com.gai_app.gai_notifications.service;

import com.gai_app.gai_notifications.exception.ResourceNotFoundException;
import com.gai_app.gai_notifications.mapper.MappingUtils;
import com.gai_app.gai_notifications.model.NotificationModel;
import com.gai_app.gai_notifications.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final MappingUtils mappingUtils;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   MappingUtils mappingUtils) {
        this.notificationRepository = notificationRepository;
        this.mappingUtils = mappingUtils;
    }


    public List<NotificationModel> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(mappingUtils::mapToNotificationModelFromEntity)
                .toList();
    }


    public NotificationModel getNotificationById(Long id) {
        return mappingUtils.mapToNotificationModelFromEntity(notificationRepository.findById(id)
                .orElseThrow(() -> ThrowableMessage(id)));
    }

    public NotificationModel createNotification(NotificationModel notification) {
        return mappingUtils.mapToNotificationModelFromEntity(notificationRepository
                .save(mappingUtils.mapToNotification(notification)));
    }


    public List<NotificationModel> getAllNotificationsByUserId(Long userId) {
        return notificationRepository.findAllByUserIdsContains(userId).stream()
                .map(mappingUtils::mapToNotificationModelFromEntity)
                .toList();
    }

    private ResourceNotFoundException ThrowableMessage(Long id) {
        return new ResourceNotFoundException("Notification with id " + id + " not found");
    }
}
