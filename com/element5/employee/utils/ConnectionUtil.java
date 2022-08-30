package com.element5.employee.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <h1> Connection Util class </h1>
 * <p>
 * This connection util class is used to connect the database commonly  
 * for all the reference.
 * </p>
 *
 * @author M Ashok Kumar
 *
 * @since 05/08/2022
 */ 
public class ConnectionUtil {

    private static Connection connection = null;

    private static Properties properties = new Properties();

    private static String fileLocation = "D:\\Users\\ashokkumar.murugan\\Music\\com\\element5\\employee\\utils\\connection.properties";

    private static final String SYSTEMPATH = fileLocation;

    private ConnectionUtil() {
    }

    static {
        try {
            FileInputStream dataBase = new FileInputStream(SYSTEMPATH);
            properties.load(dataBase);
        } catch (IOException ioException) {
            System.out.println("connection properties configuration file not found.");
        }
    }

    public static Connection getConnection() {
	String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
            try { 
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException exception) {
                System.out.println(exception.getMessage());
            }
	return connection;
    }
}

