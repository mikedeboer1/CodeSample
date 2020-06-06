package ApiConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiGetData
{
    public static String sendGET(String apiUrl, String city, String units, String apiKey) throws IOException
    {
        String inline = "";
        //builds the api get call
        String apiURLNew = apiUrl + "?q=" + city + "&units=" + units + "&appid=" + apiKey;
        String line = "";
        URL obj = new URL(apiURLNew);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // makes the connection
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        // Validates the connection was successful
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            // if the connection was succesful reads the respones into string
            Scanner sc = new Scanner(obj.openStream());
            while(sc.hasNext())
            {
                inline+=sc.nextLine();
            }
            //Close the stream when reading the data has been finished
            sc.close();
            return inline;
        } else {
            System.out.println("GET request Failed");
            return null;
        }
    }
}
