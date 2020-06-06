import ApiConnection.ApiGetData;
import ApiConnection.DataBuildEngine;

import java.io.IOException;
import java.util.List;

public class WeatherCheck
{
    // private static final String GET_URL = "http://api.openweathermap.org/data/2.5/forecast?q=minneapolis,us&units=imperial&APPID=09110e603c1d5c272f94f64305c09436";
    private static String URL = "http://api.openweathermap.org/data/2.5/forecast";
    private static String apiKey = "09110e603c1d5c272f94f64305c09436";
    private static String units = "imperial";
    private static String city = "minneapolis,us";
    public static void main(String[] args) throws IOException
    {
        String response = ApiGetData.sendGET(URL, city, units, apiKey);
        List contactData = DataBuildEngine.DataBuild(response);



    }






}
