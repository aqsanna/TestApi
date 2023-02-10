package com.swapi.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    public static final String REQRES_URL;


    static {
            REQRES_URL = getPropValues("url");

    }

    static InputStream inputStream;

    public static Properties getPropValues() throws IOException {
        String result = "";
        Properties prop = new Properties();
        try {
            String propFileName = "config.properties";
            inputStream = Configurations.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                prop = null;
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return prop;
    }

    public static String getPropValues(String key)  {

        if (System.getProperty(key) == null) {
            try {
                return getPropValues().getProperty(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return System.getProperty(key);
    }

}
