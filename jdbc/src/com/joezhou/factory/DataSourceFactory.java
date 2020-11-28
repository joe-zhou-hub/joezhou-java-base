package com.joezhou.factory;

/**
 * @author JoeZhou
 */
public class DataSourceFactory {
    public static DataSource getDataSource() {
        return new DataSource();
    }
}