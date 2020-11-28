package com.joezhou.account.dao.impl;

import com.joezhou.account.jdbc.JdbcTemplate;
import com.joezhou.account.dao.AccountDao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Map<String, Object>> getAll() {
        String sql = "SELECT `ID`, `USERNAME`, `PASSWORD`, `CREATE_DATE` FROM `ACCOUNT`";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public int create(String username, String password) {
        String sql = "INSERT INTO `ACCOUNT` (" +
                "`USERNAME`, `PASSWORD`,`CREATE_DATE`) VALUES (?, ?, NOW())";
        return jdbcTemplate.update(sql, username, password);
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM `ACCOUNT` WHERE `ID`= ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(String username, String password, int id) {
        String sql = "UPDATE `ACCOUNT` SET `USERNAME`= ?, `PASSWORD`= ? " +
                "WHERE `ID`= ?";
        return jdbcTemplate.update(sql, username, password, id);
    }
}