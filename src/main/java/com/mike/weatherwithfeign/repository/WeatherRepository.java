package com.mike.weatherwithfeign.repository;

import com.mike.weatherwithfeign.model.WeatherModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

import static com.mike.weatherwithfeign.model.TemperatureType.C;

@Repository
public class WeatherRepository {

    private final Random random = new Random();

    public Optional<WeatherModel> getWeather(final Double longitude, final Double latitude, final LocalDateTime date) {
        if (longitude > 20.0 && latitude > 20.0) {
            return Optional.of(new WeatherModel(date.truncatedTo(ChronoUnit.HOURS), random.nextDouble(40.0), C,
                    "It's rainy", "Chicago"));
        } else {
            return Optional.empty();
        }
    }
}
