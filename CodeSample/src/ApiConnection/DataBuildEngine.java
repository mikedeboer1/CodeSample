package ApiConnection;

import java.util.ArrayList;
import java.util.List;

public class DataBuildEngine
{
    public static List DataBuild(String response)
    {
        List<String> list = new ArrayList<String>();
        String elementArray[] = response.split(":");
        String tempbuilder = "";

        for (int index = 0; index < elementArray.length; index++)
        {
            if (elementArray[index].contains("temp") && elementArray[index].contains("{"))
            {
                index++;
                DataCleanUp(elementArray[index], tempbuilder);

                tempbuilder = DataCleanUp(elementArray[index], tempbuilder);
            }
            else if (elementArray[index].contains("Clear"))
            {
                tempbuilder = DataCleanUp(elementArray[index], tempbuilder);
            }
            else if (elementArray[index].contains("Rain"))
            {
                String[] weather = elementArray[index].split(",");
                tempbuilder = DataCleanUp(elementArray[index], tempbuilder);
            }
            else if (elementArray[index].contains("2020")) // TODO need to paramterize this to dynamical check for the year
            {
                String[] tempdate = elementArray[index].split("-");
                String[] day = tempdate[2].split(" ");
                tempdate[0] = tempdate[0].replace("\"","");
                tempdate[1] = tempdate[1].replaceFirst("0","");
                day[0] = day[0].replaceFirst("0","");
                String founddate = tempdate[1] + "-" + day[0] + "-" + tempdate[0] + " " + day[1];
                tempbuilder = tempbuilder + founddate + ',';


                tempbuilder = BestWaytoContact(tempbuilder, day[1]);
                System.out.println(tempbuilder);
                list.add(tempbuilder);
                tempbuilder = "";
            }
        }
        return list;
    }

    public static String BestWaytoContact(String weatherData, String timeFound)
    {
        String[] tempWeatherData = weatherData.split(",");

        // Did not feel the need to disturb people during the night and to early in the morning
        if (Integer.parseInt(timeFound) > 5 && Integer.parseInt(timeFound) < 21)
        {
            if(tempWeatherData.length==3)
            {
                if (Double.parseDouble(tempWeatherData[0]) > 75)
                {
                    if (tempWeatherData[1].contains("Clear"))
                    {
                        weatherData = weatherData + "," +  "text";
                    }
                    else if (tempWeatherData[1].contains("Rain"))
                    {
                        weatherData = weatherData + "," +  "phone";
                    }
                    else
                    {
                        weatherData = weatherData + "," +  ",";
                    }
                }
                else if (Double.parseDouble(tempWeatherData[0]) < 55)
                {
                    weatherData = weatherData + "," +  "phone";
                }
                else if (tempWeatherData[1].contains("Rain"))
                {
                    weatherData = weatherData + "," +  "phone";
                }
                else if (Double.parseDouble(tempWeatherData[0]) >= 55 && Double.parseDouble(tempWeatherData[0]) <= 75 )
                {
                    weatherData = weatherData + "," +  "email";

                }
            }
            else
            {
                if (Double.parseDouble(tempWeatherData[0])>= 55 && Double.parseDouble(tempWeatherData[0]) <= 75)
                {
                    weatherData = weatherData + "," + "email";
                }
                else if (Double.parseDouble(tempWeatherData[0]) <= 55)
                {
                    weatherData = weatherData + "," + "phone";
                }
            }

        }
        return weatherData;
    }

    private static String DataCleanUp(String stringToClean, String returnString)
    {
        String[] tempArray;

        tempArray = stringToClean.split(",");
        tempArray[0] = tempArray[0].replace("\"","");

        returnString = returnString + tempArray[0] + ",";
        return returnString;
    }
}
