package com.notifications.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.notifications.model.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notification, Long> {
}
