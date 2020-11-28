package com.joezhou.jpa.tool;

import com.joezhou.jdbc.JdbcTemplate;
import com.joezhou.jpa.annotation.Column;
import com.joezhou.jpa.annotation.Id;
import com.joezhou.jpa.annotation.Table;

import java.lang.reflect.Field;

/**
 * @author JoeZhou
 */
public class CreateTableTool {

    private Class<?> instance;

    public CreateTableTool(Class<?> instance) {
        this.instance = instance;
    }

    public void build() {
        String tableName = this.getTableName();
        String columns = this.getColumns();
        String idName = this.getIdName();
        String sqlFormat =
                "CREATE TABLE `%s` ("
                        + "`%s` INT AUTO_INCREMENT NOT NULL"
                        + "%s "
                        + "PRIMARY KEY(`%s`)"
                        + ") ENGINE=INNODB DEFAULT CHARSET=UTF8MB4";
        String sql = String.format(sqlFormat, tableName, idName, columns, idName);
        new JdbcTemplate().execute(sql);
    }

    private String getTableName() {
        return instance.getAnnotation(Table.class).value();
    }

    private String getColumns() {
        StringBuilder columns = new StringBuilder();
        for (Field field : instance.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String name = columnAnnotation.name();
                String type = columnAnnotation.type();
                int length = columnAnnotation.length();
                // ", name varchar(50)"
                columns.append(String.format(", `%s` %s(%d)", name, type, length));
            }
        }
        columns.append(",");
        return columns.toString();
    }

    private String getIdName() {
        String idName = null;
        for (Field field : instance.getDeclaredFields()) {
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation != null) {
                idName = field.getName().toUpperCase();
                break;
            }
        }
        return idName;
    }
}