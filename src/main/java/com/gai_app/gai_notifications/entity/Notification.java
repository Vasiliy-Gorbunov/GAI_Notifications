package com.gai_app.gai_notifications.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Notification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @CollectionTable(name = "notification_users_id", joinColumns = @JoinColumn(name = "notification_id"))
    @Column(name = "user_id")
    private List<Long> userIds;
    private String notification;

}
