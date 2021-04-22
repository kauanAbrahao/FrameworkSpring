package com.luv2code.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SurfCoach implements Coach{

    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return null;
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
