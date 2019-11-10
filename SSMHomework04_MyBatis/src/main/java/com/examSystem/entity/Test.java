package com.examSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    private Integer testId;
    private String testName;
    private String cqId;
    private String tfqId;
    private String saqId;

}