package com.example.proxy.weather;

public class LazyWeatherRetriever implements WeatherForecast{

    private WeatherForecast forecast;
    @Override
    public String getWeather() throws InterruptedException {
        if (forecast == null)
            forecast = new PostgresWeatherRetriever();
        return forecast.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if (forecast == null)
            forecast = new PostgresWeatherRetriever();
        return forecast.refreshData();
    }
}
