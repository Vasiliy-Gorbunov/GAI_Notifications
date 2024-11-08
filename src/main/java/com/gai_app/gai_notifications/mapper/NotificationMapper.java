package com.gai_app.gai_notifications.mapper;

import com.gai_app.gai_notifications.entity.Notification;
import com.gai_app.gai_notifications.model.NotificationModel;
import com.gai_app.gai_notifications.dto.NotificationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto toNotificationDto(NotificationModel model);

    NotificationModel toNotificationModelFromDto(NotificationDto dto);

    NotificationModel toNotificationModelFromEntity(Notification notification);

    Notification toNotification(NotificationModel model);

    List<Long> toLongList(List<Long> longList);

    List<NotificationDto> toNotificationDtoList(List<NotificationModel> notificationModelList);

    List<NotificationModel> toNotificationModelListFromDto(List<NotificationDto> notificationDtoList);

    List<NotificationModel> toNotificationModelListFromEntity(List<Notification> notificationList);

    List<Notification> toNotificationList(List<NotificationModel> notificationModelList);

}

