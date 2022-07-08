package utility;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class NetworkCapture {
    public static List<String> analyzeLog(WebDriver driver) {
        List<String> log = new ArrayList<>();
        Set<String> logTypes =  driver.manage().logs().getAvailableLogTypes();
        if (logTypes.contains(LogType.BROWSER)) {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                log.add(entry.getLevel() + " " + entry.getMessage().replaceAll("'", ""));
            }
        } else {
            log.add("This browser does not support getting console log.");
        }
        return log;
    }



    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");

        List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
        System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
        for (LogEntry entry : entries) {

            Gson gson = new Gson();
//            JsonObject entryJSON1 = gson.toJsonTree(entry.getMessage()).getAsJsonObject();

            String entryy = entry.getMessage().toString();
            String jsn = entryy.substring(1, entryy.length()-1);
            JsonObject entryJSON2 = gson.toJsonTree(jsn).getAsJsonObject();
//            System.out.println(entryJSON1);
            System.out.println(entryJSON2);

            if (entry.toString().contains("documentURL")){
//                System.out.println(entryJSON);
//                System.out.println(entryJSON.get("url"));
                System.out.println();
                break;

            }
        }
        driver.close();
    }
}
