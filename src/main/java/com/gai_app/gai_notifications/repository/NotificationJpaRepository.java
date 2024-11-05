package com.gai_app.gai_notifications.repository;

import com.gai_app.gai_notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationJpaRepository extends NotificationRepository, JpaRepository<Notification, Long> {


    List<Notification> findAll();

    Optional<Notification> findById(Long id);

    Notification save(Notification notification);

    List<Notification> findAllByUserIdsContains(Long userId);
}
