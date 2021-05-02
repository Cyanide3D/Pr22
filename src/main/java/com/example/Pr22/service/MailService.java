package com.example.Pr22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender sender;
    @Value("${email.address}")
    private String emailAddress; //Обязательно поменять в application.yml

    @Async
    public void sendMessage(String message) {
        SimpleMailMessage m = new SimpleMailMessage();
        m.setFrom(emailAddress);
        m.setTo(""); //Куда отправлять
        m.setSubject(""); //Тема сообщения
        m.setText(message); //Текст сообщения
        sender.send(m);
    }

}
