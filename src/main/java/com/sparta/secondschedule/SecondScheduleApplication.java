package com.sparta.secondschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecondScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondScheduleApplication.class, args);
    }

}
