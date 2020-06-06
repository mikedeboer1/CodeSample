package ApiConnection;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataCreation
{
    /// gets the current date plus one day and passes it in the needed format back to the app
    public static String StartingDate(Date date,int dateindex)
    {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(dateindex);
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        System.out.println();
        return month + "-" + day + "-" + year;
    }
}
