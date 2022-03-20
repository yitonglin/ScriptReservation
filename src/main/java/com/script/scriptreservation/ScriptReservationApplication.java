package com.script.scriptreservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.script.scriptreservation.dao")
@SpringBootApplication
public class ScriptReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScriptReservationApplication.class, args);
    }

}
