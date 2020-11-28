package com.joezhou.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeZhou
 */
public class DataSource {
    private static List<Connection> connectionPool;
    private static int connectionPoolSize = 10;

    static {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            initConnectionPool();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void initConnectionPool() {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < connectionPoolSize; i++) {
            connectionPool.add(createNewConnection());
        }
    }

    private static Connection createNewConnection() {
        String user = "joezhou";
        String password = "joezhou";
        String url = "jdbc:mysql://localhost:3306/dbjoe";
        String urlParam = "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        url += urlParam;
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