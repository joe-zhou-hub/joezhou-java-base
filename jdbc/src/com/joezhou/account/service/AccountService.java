package com.joezhou.account.service;

/**
 * @author JoeZhou
 */
public interface AccountService {

    /**
     * 项目启动
     */
    void start();

    /**
     * 创建一个账户信息
     *
     * @return 操作影响的条目数
     */
    int create();

    /**
     * 删除一个账户信息
     *
     * @return 操作影响的条目数
     */
    int deleteById();

    /**
     * 修改一个账户信息
     *
     * @return 操作影响的条目数
     */
    int updateById();
}