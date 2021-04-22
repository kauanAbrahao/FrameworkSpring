package com.luv2code.springdemo2;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:petsProperties")
//@ComponentScan("com.luv2code.springdemo2")
public class CoachConfig {

    @Bean
    public Coach surfCoach(){
        SurfCoach surfCoach = new SurfCoach();
        return surfCoach;
    }

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach gymCoach(){
        GymCoach gymCoach = new GymCoach();
        return gymCoach;
    }

    @Bean
    public Coach swimCoach(){
        SwimCoach swimCoach = new SwimCoach();
        return swimCoach;
    }

    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }

    @Bean
    public FortuneService outroHappyFortuneService(){
        return new HappyFortuneService();
    }
}
