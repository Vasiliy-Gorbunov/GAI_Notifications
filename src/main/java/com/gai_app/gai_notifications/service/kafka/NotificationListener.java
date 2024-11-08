package com.gai_app.gai_notifications.service.kafka;

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
                ("(\\w+) with (?:\\w+ )?id (\\d+|\\[\\d+(?:,\\s(\\d+))*)");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            switch (matcher.group(1)) {
                case "Owner":
                case "License":
                    userIds.add(-2L);
                    userIds.add(Long.parseLong(matcher.group(2)));
                    break;
                case "Car":
                    userIds.add(-3L);
                    userIds.add(Long.parseLong(matcher.group(2)));
                    break;
                case "Passport":
                    userIds.add(-2L);
                    userIds.add(-3L);
                    Pattern num = Pattern.compile("\\d+");
                    Matcher match = num.matcher(matcher.group(2));
                    while (match.find()) {
                        userIds.add(Long.parseLong(match.group()));
                    }
                    break;
            }
        }
        notificationModel.setUserIds(userIds);
        notificationModel.setNotification(message);
        notificationService.createNotification(notificationModel);
        System.out.println("Received notification: " + message);
    }
}
