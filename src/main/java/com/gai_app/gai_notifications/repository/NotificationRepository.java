package com.gai_app.gai_notifications.repository;

import com.gai_app.gai_notifications.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {

    List<Notification> findAll();

    Optional<Notification> findById(Long id);

    Notification save(Notification notification);

    List<Notification> findAllByUserIdsContains(Long userId);
}