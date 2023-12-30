package art.jeanyvehector.controller;

import art.jeanyvehector.service.EmailServiceImpl;
import art.jeanyvehector.dto.EmailClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class EmailController {
    final
    EmailServiceImpl emailService;

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailClient emailClient) {
        try {
            emailService.sendSimpleMessage(emailClient.getEmailFrom(), emailClient.getEmailTo(), "Thanks For Contacting Jean Yves Art", "Thank you for reaching out to Jean Yves Art. We will respond to your inquiry as soon as possible.");


            emailService.sendSimpleMessage(emailClient.getEmailTo(), emailClient.getEmailFrom(), emailClient.getSubject(), emailClient.getMessage());
            return new ResponseEntity<>("Thank for your message", HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}