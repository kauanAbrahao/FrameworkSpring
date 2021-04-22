package com.luv2code.springdemo2;

public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Shitty day";
    }
}
