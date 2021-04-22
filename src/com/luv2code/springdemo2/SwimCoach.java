package com.luv2code.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SwimCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "swing for 5 minutos!";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getEmail() {
        return null;
    }
}
