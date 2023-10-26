package com.mike.weatherwithfeign.dto;

import java.time.LocalDateTime;

public record WeatherResponse(LocalDateTime date, String weatherConditions, String temperature, String city) {

    public static WeatherResponse empty() {
        return new WeatherResponse(LocalDateTime.now(), null, null, "No data found");
    }
}
