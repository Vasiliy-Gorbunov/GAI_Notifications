package com.gai_app.gai_notifications.config.kafka;

import com.gai_app.gai_notifications.model.NotificationModel;
import com.gai_app.gai_notifications.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NotificationListener {

    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "notification-topic", groupId = "notifications-group")
    public void listen(String message) {
        NotificationModel notificationModel = new NotificationModel();
        List<Long> userIds = new ArrayList<>();
        userIds.add(-1L); //for head inspector
        Pattern pattern = Pattern.compile
                ("(\\w+) with (?:\\w+ )?id (\\d+|(?:\\[(\\d+)))?(?:,\\s*(\\d+))*");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            int groupCount = matcher.groupCount();
            String entity = matcher.group(1);
            if (entity.equals("Car")) {
                userIds.add(-3L); //for car inspector
            } else {
                userIds.add(-2L); //for owner inspector
                for (int i = 2; i <= groupCount; i++) {
                    userIds.add(Long.parseLong(matcher.group(i))); //for every owner
                }
            }
        }
        notificationModel.setUserIds(userIds);
        notificationModel.setNotification(message);
        notificationService.createNotification(notificationModel);
        System.out.println("Received notification: " + message);
    }
}
