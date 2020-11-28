package com.joezhou.jpa;

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
        System.out.println(this.getCreateTableSql());
        //TODO 调用JDBC的executeUpdate方法发送这个SQL即可完成造表
    }

    private String getCreateTableSql() {
        String tableName = this.getTableName();
        String columns = this.getColumns();
        String idName = this.getIdName();
        String sqlFormat =
                "CREATE TABLE `%s` ("
                        + "`%s` INTEGER(11) AUTO_INCREMENT NOT NULL"
                        + "%s "
                        + "PRIMARY KEY(`%s`)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
        return String.format(sqlFormat, tableName, idName, columns, idName);
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
                // ", user_name varchar(50)"
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
                idName = field.getName();
                break;
            }
        }
        return idName;
    }
}