package com.develogical;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ape19 on 13/07/2016.
 */
public class ForecastProxy implements IForecastAdapter {

    public static final long HOUR = 3600*1000; // in milli-seconds.

    private HashMap<String,CachedWeather> cache = new HashMap<String,CachedWeather>();
    private ForecastAdapter forecastAdapter;

    public ForecastProxy(ForecastAdapter forecastAdapter) {

        this.forecastAdapter = forecastAdapter;
    }

    @Override
    public int getForcast(String region, WeekDays day) {

        //check if the string exists in the hashmap

        //if so read form cache
        CachedWeather cachedData = cache.get(region);

        if(cachedData != null){

            long current = new Date().getTime();

            long newDate = new Date( current - 1 * HOUR).getTime();
            if(cachedData.time.getTime() > newDate){
                return cachedData.tempreture;
            }


        }

        // if not call he adaptor
        int tempreture = forecastAdapter.getForcast(region, day);
        CachedWeather cacheData = new CachedWeather();
        cacheData.RegionName = region;
        cacheData.tempreture = tempreture;
        cacheData.time = new Date();

            //insert in the cache
        cache.put(region+day.toString(),cacheData);



        return 0;
    }

}