package com.notifications.api;

import com.notifications.dto.NotificationRequest;
import com.notifications.service.INotificationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NotificationsApi {

    private final INotificationsService notificaService;

    public NotificationsApi(INotificationsService notificaService) {
        this.notificaService = notificaService;
    }

    @PostMapping
    @RequestMapping("/sendNotification")
    @ResponseStatus(code = HttpStatus.OK)
    public void sendNotification(@RequestBody @Valid NotificationRequest notificationRequest){
        notificaService.sendNotification(notificationRequest);
    }

}
