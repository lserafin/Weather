package com.develogical;

public class Example {

    public static void main(String[] args) {

        // This is just an example of using the 3rd party API - delete this class before submission.


        IForecastAdapter forecaster = new ForecastAdapter();

        int londonForecast = forecaster.getForcast("LONDON", WeekDays.MONDAY);
        System.out.println("London temperature: " + londonForecast);

        int edinburghForecast = forecaster.getForcast("EDINBURGH", WeekDays.MONDAY);
        System.out.println("Edinburgh temperature: " + edinburghForecast);
    }
}
