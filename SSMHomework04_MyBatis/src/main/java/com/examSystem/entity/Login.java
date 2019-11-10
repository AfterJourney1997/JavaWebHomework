package com.examSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private Integer id;
    private Integer identity;
    private String account;
    private String password;
    private String content;

}