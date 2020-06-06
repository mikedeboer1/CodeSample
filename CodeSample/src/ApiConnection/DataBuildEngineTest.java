package ApiConnection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataBuildEngineTest {
// Todo I need to break these intoindividual tests to showpassing of each data combo
        private static  String[] weatherTestData = {    "75,Rain,6-5-2020 11,phone",
                                                        "55,,6-5-2020 13,email",
                                                        "54,,6-5-2020 14,phone",
                                                        "55,Rain,6-5-2020 15,phone",
                                                        "54,Rain,6-5-2020 16,phone",
                                                         "76,Clear,6-5-2020 08,text",
                                                         "74.99,Clear,6-5-2020 06,email",
                                                         "75,Clear,6-5-2020 07,email",
                                                         "75,,6-5-2020 09,email",
                                                         "76,Rain,6-5-2020 10,phone"

        };

    @Test
    public void testdataGenerator()
    {
        for (int index = 0; index < weatherTestData.length;index++)
        {
            String[] tempdata = weatherTestData[index].split(",");
            String dataTocheck = "";
            String[] time = tempdata[2].split(" ");
            if (tempdata[1] == "")
            {
                dataTocheck = tempdata[0]+","+tempdata[2];
            }
            else
            {
                dataTocheck = tempdata[0] + "," + tempdata[1] + "," + tempdata[2];
            }
            String test = DataBuildEngine.BestWaytoContact(dataTocheck, time[1]);
            String[] communcationType = test.split(",");

            Assertions.assertEquals(tempdata[3],communcationType[3]);
        }
    }


}