package com.middleware.app.cow.mail;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.service.MailService;
import com.middleware.app.cow.service.impl.MailServiceImpl;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class MailServiceTestIT {

    @Autowired
    private JavaMailSender javaMailSender;

    private MailService mailService;

    @Test
    public void sendMail() {
        mailService = new MailServiceImpl(javaMailSender);

        String template = "index.vm";

        Map config = new HashMap();
        config.put("to", "jmchincho@icloud.com");
        config.put("from", "no-reply@capitanoferta.com");
        config.put("subject", "PRUEBA");

        Map model = new HashMap();
        model.put("name", "FUNCIONA EL TEST DEL ENVIO");

        mailService.sendMail(template, model, config);

    }
}