package com.mybatisSQL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Integer id;
    private String name;
    private Float price;
    private String pic;
    private Date createtime;
    private String detail;

}