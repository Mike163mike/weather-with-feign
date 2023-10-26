package com.mike.weatherwithfeign.facade;

import com.mike.weatherwithfeign.dto.WeatherRequest;
import com.mike.weatherwithfeign.dto.WeatherResponse;
import com.mike.weatherwithfeign.feign.ExternalWeatherApi;
import com.mike.weatherwithfeign.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherFacade.class);

    private final WeatherService weatherService;
    private final ExternalWeatherApi externalWeatherApi;

//    @Value("${api-key}")
//    private String appid;

    public WeatherResponse getWeather(WeatherRequest request) {

        return weatherService.getWeather(request.longitude(), request.latitude(), request.date())
                .map(weatherModel -> new WeatherResponse(weatherModel.date(),
                                weatherModel.weatherConditions(),
                                weatherModel.temperature() + " " +
                                        weatherModel.type() + "° from local repository",
                        weatherModel.city()))
                .orElse(getExternalWeather(request));
    }

    private WeatherResponse getExternalWeather(final WeatherRequest request) {
        String response1 = String.valueOf(externalWeatherApi.getExternalWeather(request.latitude(), request.longitude()));
        LOGGER.info("From openweather: {}", response1);
        return Optional.ofNullable(externalWeatherApi.getExternalWeather(request.latitude(), request.longitude()))
                .map(response -> new WeatherResponse(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS),
                        response.weather()[0].get("description"),
                        response.mainSection().get("temp") +
                        "° from openweather resource",
                        response.cityName()))
                .orElse(WeatherResponse.empty());
    }
}
