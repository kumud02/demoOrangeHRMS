package settings;


import interfaces.IConfigReader;
import org.apache.poi.ss.usermodel.Row;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectRepo {
    public static IConfigReader reader;
    public static Map<String, Object> data = new LinkedHashMap<String, Object>();
    public static Row testDataVariables;
    public static Row testData;
    public static String DataVar;
    public static SoftAssert softAssert = new SoftAssert();
    public static int DataRowNo;
    public static String Environment;

}
