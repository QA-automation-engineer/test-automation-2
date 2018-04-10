package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredsManager {
    private static final Logger LOG = LogManager.getLogger(CredsManager.class);

    private static Properties properties = new Properties();

    public static String getCred(String cred){
        try(InputStream inputStream = new FileInputStream("creds.properties")){
            properties.load(inputStream);
            return properties.getProperty(cred);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
