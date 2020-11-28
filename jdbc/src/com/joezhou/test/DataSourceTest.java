package com.joezhou.test;
import com.joezhou.factory.DataSource;
import com.joezhou.factory.DataSourceFactory;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author JoeZhou
 */
public class DataSourceTest {

    @Test
    public void datasource() {
        com.joezhou.datasource.DataSource dataSource = new com.joezhou.datasource.DataSource();
        Connection connection = dataSource.getConnection();
        try {
            System.out.println(connection.isClosed() ? "fail" : "success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }

    @Test
    public void pool() {
        com.joezhou.pool.DataSource dataSource = new com.joezhou.pool.DataSource();
        Connection connection = dataSource.getConnection();
        try {
            System.out.println(connection.isClosed() ? "fail" : "success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }

    @Test
    public void properties() {
        com.joezhou.properties.DataSource dataSource = new com.joezhou.properties.DataSource();
        Connection connection = dataSource.getConnection();
        try {
            System.out.println(connection.isClosed() ? "fail" : "success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }

    @Test
    public void factory() {
        DataSource dataSource = DataSourceFactory.getDataSource();
        Connection connection = dataSource.getConnection();
        try {
            System.out.println(connection.isClosed() ? "fail" : "success");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataSource.closeConnection(connection);
        }
    }
}
