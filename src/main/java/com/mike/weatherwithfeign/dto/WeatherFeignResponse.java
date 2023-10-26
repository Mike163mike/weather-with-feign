package com.mike.weatherwithfeign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherFeignResponse(

        @JsonProperty("coord")
        Map<String, Double> coordinates,
        @JsonProperty("weather")
        Map<String, String>[] weather,
        @JsonProperty("main")
        Map<String, Double> mainSection,
        @JsonProperty("name")
        String cityName) {
}
