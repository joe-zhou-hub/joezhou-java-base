package com.joezhou.jdbc;

import com.joezhou.factory.DataSource;
import com.joezhou.factory.DataSourceFactory;

import java.sql.*;
import java.util.*;

/**
 * @author JoeZhou
 */
public class JdbcTemplate {

    private DataSource dataSource = DataSourceFactory.getDataSource();

    public boolean execute(String sql) {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            result = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
            dataSource.closeConnection(connection);
        }
        return result;
    }

    public int update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        int result = -1;
        try {
            connection = dataSource.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            result = sendSqlAndGetInt(prepareStatement, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(prepareStatement);
            dataSource.closeConnection(connection);
        }
        return result;
    }

    public int[] batchUpdate(String sql, Object[]... params) {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        int[] result = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            prepareStatement = connection.prepareStatement(sql);
            result = sendSqlAndGetIntArray(prepareStatement, params);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeStatement(prepareStatement);
            dataSource.closeConnection(connection);
        }
        return result;
    }

    public int[] batchUpdate(String... sqls) {
        Connection connection = null;
        Statement statement = null;
        int[] result = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            result = sendSqlAndGetIntArray(statement, sqls);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeStatement(statement);
            dataSource.closeConnection(connection);
        }
        return result;
    }

    public List<Map<String, Object>> queryForList(String sql, Object... params) {
        List<Map<String, Object>> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            resultSet = sendSqlAndGetResultSet(prepareStatement, params);
            result = changeResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(prepareStatement);
            dataSource.closeConnection(connection);
        }
        return result;
    }

    public Map<String, Object> queryForMap(String sql, Object... params) {
        Map<String, Object> resultMap = new HashMap<>(10);
        List<Map<String, Object>> list = queryForList(sql, params);
        if (!list.isEmpty()) {
            resultMap = list.get(0);
        }
        return resultMap;
    }

    public int queryForInt(String sql, Object... params) {
        int result = -1;
        Map<String, Object> map = queryForMap(sql, params);
        Object value = null;
        for (String key : map.keySet()) {
            value = map.get(key);
            break;
        }
        if (value != null) {
            result = Integer.parseInt(value.toString());
        }
        return result;
    }

    private int[] sendSqlAndGetIntArray(Statement statement, String... sqls) throws SQLException {
        for (String sql : sqls) {
            statement.addBatch(sql);
        }
        return statement.executeBatch();
    }

    private int sendSqlAndGetInt(PreparedStatement prepareStatement, Object... params) throws SQLException {
        for (int i = 0, j = params.length; i < j; i++) {
            prepareStatement.setObject(i + 1, params[i]);
        }
        return prepareStatement.executeUpdate();
    }

    private int[] sendSqlAndGetIntArray(PreparedStatement prepareStatement, Object[]... params) throws SQLException {
        for (Object[] param : params) {
            for (int i = 0, j = param.length; i < j; i++) {
                prepareStatement.setObject(i + 1, param[i]);
            }
            prepareStatement.addBatch();
        }
        return prepareStatement.executeBatch();
    }

    private ResultSet sendSqlAndGetResultSet(PreparedStatement prepareStatement, Object... params) throws SQLException {
        for (int i = 0, j = params.length; i < j; i++) {
            prepareStatement.setObject(i + 1, params[i]);
        }
        return prepareStatement.executeQuery();
    }

    private List<Map<String, Object>> changeResultSetToList(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> resultList = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map<String, Object> tempMap;

        // rows
        while (resultSet.next()) {
            tempMap = new HashMap<>(10);
            // columns in row, iter from 1
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(columnName);
                tempMap.put(columnName, value);
            }
            resultList.add(tempMap);
        }
        return resultList;
    }

    private void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
