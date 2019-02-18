package com.example.retrofit_practice;

public class WeatherEntity {

    NestedCurrently currently;
}

class NestedCurrently{

    String summary;

    float temperature;

    float humidity;

    float pressure;

    float windSpeed;

    float cloudCover;

}
