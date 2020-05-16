package com.example.stock.service.facade;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.example.stock.bean.NotificationEmploye;

public interface NotificationEmployeService {
	List<NotificationEmploye> findByEmployeId(Long id);
	List<NotificationEmploye> findByEmployeEmail(String email);
	List<NotificationEmploye> findByemployeDoti(Integer doti);
	List<NotificationEmploye> findByDateDeNotification(Date dateDeObtenation);

	List<NotificationEmploye> findAll();

	int save(NotificationEmploye notificationEmploye);

	int deleteById(Long id);

	public NotificationEmploye findByid(Long id);
	public int sendmail(String email, String subject,String content) throws AddressException, MessagingException, IOException;
	}
