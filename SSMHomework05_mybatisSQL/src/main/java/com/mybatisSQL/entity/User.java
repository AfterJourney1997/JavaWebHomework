package com.mybatisSQL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private List<Order> orders;

}