package com.assignment.util;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	 private static final Properties properties = new Properties();

	    static {

	        try (InputStream input =
	                     ConfigLoader.class.getClassLoader()
	                             .getResourceAsStream("config.properties")) {

	            properties.load(input);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    public static String getIP() {
	        return properties.getProperty("server.ip");
	    }

	    public static int getPort() {
	        return Integer.parseInt(properties.getProperty("server.port"));
	    }

	    public static String getKey() {
	        return properties.getProperty("aes.key");
	    }
}
