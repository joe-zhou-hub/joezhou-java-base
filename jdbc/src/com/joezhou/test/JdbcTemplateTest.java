package com.joezhou.test;

import com.joezhou.jdbc.JdbcTemplate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class JdbcTemplateTest {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Test
    public void execute() {
        String sql = "CREATE TABLE `JDBC` (" +
                "`ID` INT AUTO_INCREMENT PRIMARY KEY ," +
                "`NAME` VARCHAR(50) NOT NULL) " +
                "ENGINE = INNODB DEFAULT CHARSET UTF8MB4";
        System.out.println(jdbcTemplate.execute(sql));
    }

    @Test
    public void insert() {
        String sql = "INSERT INTO `JDBC` (`NAME`) VALUES (?)";
        System.out.println(jdbcTemplate.update(sql, "zhaosi"));
    }

    @Test
    public void update() {
        String sql = "UPDATE `JDBC` SET `NAME` = ? WHERE `ID` = ?";
        System.out.println(jdbcTemplate.update(sql, "liuneng", 1));
    }

    @Test
    public void delete() {
        String sql = "DELETE FROM `JDBC` WHERE `ID` = ?";
        System.out.println(jdbcTemplate.update(sql, 1));
    }

    @Test
    public void batchInsertWithSameSql() {
        String sql = "INSERT INTO `JDBC` (`NAME`) VALUES (?)";
        Object[] param01 = {"zhaosi"};
        Object[] param02 = {"liuneng"};
        Object[] param03 = {"guangkun"};
        int[] result = jdbcTemplate.batchUpdate(sql, param01, param02, param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchUpdateWithSameSql() {
        String sql = "UPDATE `JDBC` SET `NAME` = ? WHERE `ID` = ?";
        Object[] param01 = {"zhaosi2", 3};
        Object[] param02 = {"liuneng2", 4};
        Object[] param03 = {"guangkun2", 5};
        int[] result = jdbcTemplate.batchUpdate(sql, param01, param02, param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchDeleteWithSameSql() {
        String sql = "DELETE FROM `JDBC` WHERE `ID` = ?";
        Object[] param01 = {3};
        Object[] param02 = {4};
        Object[] param03 = {5};
        int[] result = jdbcTemplate.batchUpdate(sql, param01, param02, param03);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void batchUpdateWithDifferentSql() {
        String insertSql = "INSERT INTO `JDBC` (`NAME`) VALUES ('FEIJI')";
        String updateSql = "UPDATE `JDBC` SET `NAME` = 'DAPAO' WHERE `NAME` = 'FEIJI'";
        String[] sqls = {insertSql, updateSql};
        int[] result = jdbcTemplate.batchUpdate(sqls);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void queryForList() {
        String sql = "SELECT * FROM EMP WHERE ENAME != ? AND SAL > ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "SMITH", 1500);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void queryForMap() {
        String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 7654);
        System.out.println(map);
    }

    @Test
    public void queryForInt() {
        String sql = "SELECT COUNT(`ID`) FROM JDBC WHERE ID > ?";
        System.out.println(jdbcTemplate.queryForInt(sql,8));
    }


}
