package com.joezhou.jpa;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
@Table("userInfo")
public class User implements Serializable {
    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age", type = "integer", length = 10)
    private String userAge;
}