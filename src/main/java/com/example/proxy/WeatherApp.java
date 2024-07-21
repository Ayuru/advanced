package com.example.proxy;

import com.example.proxy.weather.LazyWeatherRetriever;
import com.example.proxy.weather.PostgresWeatherRetriever;
import com.example.proxy.weather.WeatherForecast;

import java.util.Random;

public class WeatherApp {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        for (int n = 0; n < 6; n++) {
            WeatherForecast forecast = new LazyWeatherRetriever();
            int number = new Random().nextInt(100);
            if (number < 20)
                System.out.println(forecast.refreshData());
            else System.out.println(forecast.getWeather());

            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}