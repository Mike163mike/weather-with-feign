package com.mike.weatherwithfeign.feign;

import com.mike.weatherwithfeign.dto.WeatherFeignResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather")
public interface ExternalWeatherApi {

    @GetMapping
    @CircuitBreaker(name = "weather-breaker")
    @Retry(name = "weather-retry")
    WeatherFeignResponse getExternalWeather(@RequestParam Double lat,
                                      @RequestParam Double lon);

}
