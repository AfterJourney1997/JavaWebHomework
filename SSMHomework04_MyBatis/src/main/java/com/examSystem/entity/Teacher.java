package com.examSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Integer id;
    private String tAccount;
    private String tName;
    private String scId;

}