package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Logger log = LoggerFactory.getLogger(Configuration.class);
    private static final String DEFAULT_PROPERTIES = "default.properties";
    private static Properties properties;

    private static Properties readProperties(){
        Properties property = new Properties();
        try(InputStream stream = ResourceLoader.getResources(DEFAULT_PROPERTIES)){
            property.load(stream);
        }catch (Exception e) {
            log.error("Unable to Load Properties: {}", DEFAULT_PROPERTIES, e);
        }
        return property;
    }

    /**
     * Initialize the Properties to be used.
     * Loads default properties, checks if any property is passed via command line and initializes accordingly
     */
    public static void initialize(){

        //Load Default Properties
        properties = readProperties();

        // check for any override
        for(String key: properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }

        log.info("=============================================================================");
        log.info("***** TEST PROPERTIES USED: *****");
        for(String key: properties.stringPropertyNames()){
            log.info("{}={}",key, properties.getProperty(key));
        }
        log.info("=============================================================================");
        log.info("=============================================================================");
    }

    /**
     * Returns the property value to be used in the tests
     * @param key
     * @return String
     */
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
