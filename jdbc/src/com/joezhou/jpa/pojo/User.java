package com.joezhou.jpa.pojo;

import com.joezhou.jpa.annotation.Column;
import com.joezhou.jpa.annotation.Id;
import com.joezhou.jpa.annotation.Table;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
@Table("USER")
public class User implements Serializable {

    @Id
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE", type = "INT", length = 3)
    private String age;
}