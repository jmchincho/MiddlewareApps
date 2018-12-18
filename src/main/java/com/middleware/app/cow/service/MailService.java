package com.middleware.app.cow.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MailService {

    void sendMail(String template, Map model, Map config);

}
