package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.service.MailService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String template, Map model, Map config) {
        MimeMessagePreparator preparator = new Preparator(template, model, config);

        this.javaMailSender.send(preparator);
    }

    private class Preparator implements MimeMessagePreparator {

        private static final String SRC_MAIN_RESOURCES_TEMPLATES = "./src/main/resources/templates/";
        private static final String FROM = "from";
        private static final String TO = "to";
        private static final String SUBJECT = "subject";
        private static final String CHARSET_UTF8 = "UTF-8";

        private String template;

        private Map model;

        private Map config;

        public Preparator(String template, Map model, Map config) {
            this.template = template;
            this.model = model;
            this.config = config;
        }

        @Override
        public void prepare(MimeMessage mimeMessage) throws Exception {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(((String)this.config.get(TO)));
            message.setFrom(((String)this.config.get(FROM)));
            message.setSubject(((String)this.config.get(SUBJECT)));

            message.setText(getTemplate(this.template, this.model).toString(), true );
        }

        private StringWriter getTemplate(String template, Map models) {
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.init();

            Template t = velocityEngine.getTemplate(SRC_MAIN_RESOURCES_TEMPLATES + template);
            t.setEncoding(CHARSET_UTF8);
            VelocityContext velocityContext = new VelocityContext();
            models.forEach((k ,v) -> {
                velocityContext.put(k.toString(), v);
                System.out.println(k.toString());
            });

            StringWriter writer = new StringWriter();
            t.merge( velocityContext, writer );

            return writer;
        }
    }
}
