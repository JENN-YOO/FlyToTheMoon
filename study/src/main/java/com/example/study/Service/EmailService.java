package com.example.study.Service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendConfirmationEmail(String email) {

        System.out.println("이메일 발송 시작: " + email);

        try{
            Thread.sleep(2000);
        }  catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("이메일 발송 완료: " + email);

    }
}
