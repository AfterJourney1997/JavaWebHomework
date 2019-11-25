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
public class Order {

    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private String note;
    private User user;
    private List<Item> items;

}