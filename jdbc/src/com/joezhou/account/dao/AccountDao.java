package com.joezhou.account.dao;

import java.util.List;
import java.util.Map;

/**
 * @author JoeZhou
 */
public interface AccountDao {

    /**
     * Get all account information
     *
     * @return all account information
     */
    List<Map<String, Object>> getAll();

    /**
     * Create an account information
     *
     * @param username username
     * @param password password
     * @return Number of entries affected by the operation
     */
    int create(String username, String password);

    /**
     * Delete an account information by the primary key
     *
     * @param id 主键
     * @return Number of entries affected by the operation
     */
    int deleteById(int id);

    /**
     * Modify an account information by the primary key
     *
     * @param username username
     * @param password password
     * @param id       id
     * @return Number of entries affected by the operation
     */
    int updateById(String username, String password, int id);
}