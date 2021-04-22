package com.luv2code.springdemo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);
        Coach coach = context.getBean("gymCoach", Coach.class);
        Coach coach2 = context.getBean("swimCoach", Coach.class);
        Coach surfCoach = context.getBean("surfCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getFortune() + " email: " + coach.getEmail());
        System.out.println(coach2.getFortune());

        System.out.println(surfCoach.getFortune());
    }
}
