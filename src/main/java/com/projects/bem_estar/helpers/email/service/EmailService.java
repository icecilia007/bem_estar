package com.projects.bem_estar.helpers.email.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}

