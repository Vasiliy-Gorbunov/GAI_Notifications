package com.gai_app.gai_notifications.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class NotificationModel {

    private Long id;
    private List<Long> userIds;
    private String notification;

}
