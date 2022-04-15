package org.qa.tool.cucumber.base.util;


import java.io.FileInputStream;
import java.util.Properties;

public class DriverProperty {
    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            FileInputStream input = null;
            try {
                input = new FileInputStream("src/test/resources/properties/driver.properties");
                prop.load(input);
            }catch(Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
       return prop.getProperty(key);
    }
}
