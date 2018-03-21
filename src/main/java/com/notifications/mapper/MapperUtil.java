package com.notifications.mapper;

import com.notifications.dto.NotificationRequest;
import com.notifications.model.Notification;
import com.notifications.provider.dto.FaxResponse;

public class MapperUtil {

    public static Notification mapperFaxResponse(FaxResponse faxResponse, NotificationRequest notificationRequest){
        Notification notification = new Notification();
        notification.setMsg(notificationRequest.getMsg());
        notification.setPhoneNumber(notificationRequest.getPhoneNumber());
        notification.setStatus(faxResponse.getStatus());

        return notification;
    }
}