package com.joezhou.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author JoeZhou
 */
public class DataSource {
    private static List<Connection> connectionPool;
    private static int connectionPoolSize;
    private static String driver;
    private static String user;
    private static String password;
    private static String url;

    static {
        readPropertiesFile();
        try {
            Class.forName(driver);
            initConnectionPool();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readPropertiesFile() {
        ResourceBundle bundle = PropertyResourceBundle.getBundle("db");
        driver = bundle.getString("jdbc.driver");
        user = bundle.getString("jdbc.user");
        password = bundle.getString("jdbc.password");
        url = bundle.getString("jdbc.url");
        connectionPoolSize = Integer.parseInt(bundle.getString("jdbc.connectionPoolSize"));
    }

    private static void initConnectionPool() {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < connectionPoolSize; i++) {
            connectionPool.add(createNewConnection());
        }
    }

    private static Connection createNewConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        if (connectionPool.isEmpty()) {
            connection = createNewConnection();
        } else {
            connection = connectionPool.remove(0);
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            if (connectionPool.size() < connectionPoolSize) {
                connectionPool.add(connection);
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}