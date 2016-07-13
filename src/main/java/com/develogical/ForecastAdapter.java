package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

/**
 * Created by ape19 on 13/07/2016.
 */
public class ForecastAdapter implements IForecastAdapter {

    private Forecaster forecaster;

    public ForecastAdapter(){
         this.forecaster = new Forecaster();
    }

    @Override
    public int getForcast(String region, WeekDays day) {
        Forecast forcast = this.forecaster.forecastFor(Region.valueOf(region), Day.valueOf(day.toString()));
        return forcast.temperature();
    }
}
