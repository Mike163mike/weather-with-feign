package com.mike.weatherwithfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherWithFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherWithFeignApplication.class, args);
    }

}
