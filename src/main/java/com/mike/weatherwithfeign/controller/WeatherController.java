package com.mike.weatherwithfeign.controller;

import com.mike.weatherwithfeign.dto.WeatherRequest;
import com.mike.weatherwithfeign.dto.WeatherResponse;
import com.mike.weatherwithfeign.facade.WeatherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherFacade weatherFacade;

    @GetMapping
    public WeatherResponse getWeather(@RequestBody final WeatherRequest request) {
        return weatherFacade.getWeather(request);

    }
}
