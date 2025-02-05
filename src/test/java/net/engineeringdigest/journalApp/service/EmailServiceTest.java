package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @Test
    void testEmail(){
        emailService.sendEmail("Atulpatidar1709@gmail.com", "Testing Journal Entry App", "Hi , How are you");
    }
}
