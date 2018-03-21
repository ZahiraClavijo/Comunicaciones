package com.notifications.service;

import com.notifications.dto.NotificationRequest;

public interface INotificationsService {

    void sendNotification(NotificationRequest notificationRequest);
}
