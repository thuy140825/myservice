package com.example.sms.controller;

import com.example.sms.twilio.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class TwilioSMSController {

    private final SmsService smsService;

    @Autowired
    public TwilioSMSController(SmsService smsService) {
        this.smsService = smsService;
    }
    

    @PostMapping("/send")
    public String sendSms(
            @RequestParam String configName,
            @RequestParam String toPhoneNumber,
            @RequestParam String messageBody) {
        return smsService.sendSms(configName, toPhoneNumber, messageBody);
    }

    @PostMapping("/send-specific")
    public String sendSmsWithSpecificClient(
            @RequestParam String configName,
            @RequestParam String toPhoneNumber,
            @RequestParam String messageBody) {
        return smsService.sendSmsWithSpecificClient(configName, toPhoneNumber, messageBody);
    }

}
