package com.merveadler.manager;

import com.merveadler.dto.request.ForgotPasswordToMailSendLinkRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.merveadler.constant.ApiUrls.*;

@FeignClient(url = "http://localhost:8085/api/v1/mail", name = "auth-mail")
public interface IEmailManager {
    @PostMapping(FORGOT_PASSWORD_SEND_MAIL_TOKEN)
    public ResponseEntity<Boolean> forgotPasswordMail(@RequestBody ForgotPasswordToMailSendLinkRequestDto forgotPassword);
}
