package com.notifications.service.impl;

import com.notifications.dao.NotificationsRepository;
import com.notifications.dto.NotificationRequest;
import com.notifications.mapper.MapperUtil;
import com.notifications.model.Notification;
import com.notifications.provider.IProviderService;
import com.notifications.provider.dto.FaxResponse;
import com.notifications.service.ComunicationType;
import com.notifications.service.INotificationsService;
import org.springframework.stereotype.Service;

@Service
public class NotificationsServiceImpl implements INotificationsService {

    private final IProviderService providerService;
    private final NotificationsRepository dao;

    public NotificationsServiceImpl(IProviderService providerService, NotificationsRepository dao) {
        this.providerService = providerService;
        this.dao = dao;
    }

    public void sendNotification(NotificationRequest notificationRequest) {
        ComunicationType comunicationType = ComunicationType.valueOf(notificationRequest.getType());
        if (ComunicationType.FAX.name().equals(notificationRequest.getType())) {
            // Tinsa FAX Service
            FaxResponse faxResponse = providerService.sendNotification(notificationRequest.getPhoneNumber(),
                    notificationRequest.getMsg());
            Notification notification = MapperUtil.mapperFaxResponse(faxResponse, notificationRequest);

            dao.save(notification);
        }
    }
}
