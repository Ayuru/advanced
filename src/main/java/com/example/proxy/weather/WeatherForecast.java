package com.example.proxy.weather;

public interface WeatherForecast {
    String getWeather() throws InterruptedException;
    String refreshData() throws InterruptedException;
}
