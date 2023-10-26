package com.mike.weatherwithfeign.model;

import java.time.LocalDateTime;

public record WeatherModel(LocalDateTime date, Double temperature, TemperatureType type,
                           String weatherConditions, String city) {
}
