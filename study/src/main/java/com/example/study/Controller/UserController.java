package com.example.study.Controller;

import com.example.study.Service.EmailService;
import com.example.study.Service.UserService;
import com.example.study.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    // 사용자 저장
    @PostMapping
    public User createUser(@RequestBody User user) {

        //카프카로 이메일 발송
        kafkaTemplate.send("user-email", user.getEmail());
        System.out.println("Kafka로 메시지 발송 : " + user.getEmail());

        return userService.saveUser(user);
    }

    // 사용자 조회
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


}

