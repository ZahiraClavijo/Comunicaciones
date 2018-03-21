package com.notifications.provider;

import com.notifications.provider.dto.FaxResponse;

public interface IProviderService {

    FaxResponse sendNotification(String phoneNumber, String msg);

}
