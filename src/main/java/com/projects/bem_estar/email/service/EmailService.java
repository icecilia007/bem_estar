package com.projects.bem_estar.email.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}

