package com.luv2code.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class GymCoach implements Coach {

    @Autowired
    @Qualifier("outroHappyFortuneService")
    private FortuneService fortuneService;

    @Value("${valor.email}")
    private String email;

    public String getEmail() {
        return email;
    }

    @Override
    public String getDailyWorkout() {
        return "Go run for 10 min";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }
}
