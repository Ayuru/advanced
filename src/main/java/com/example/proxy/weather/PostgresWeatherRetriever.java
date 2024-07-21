package com.example.proxy.weather;

public class PostgresWeatherRetriever implements WeatherForecast {
    @Override
    public String getWeather() {
        return "It's pleasantly warm, over 30 degrees. : >";
    }

    @Override
    public String refreshData() throws InterruptedException {
        Thread.sleep(5000);
        return "Storm is coming.";

    }
}
