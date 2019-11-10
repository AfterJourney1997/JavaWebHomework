package com.examSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    private Integer answerId;
    private Integer arrId;
    private Integer testId;
    private String sAccount;
    private String sName;
    private String cqAnswer;
    private String tfqAnswer;
    private Float sResult;
    private String saqAnswer;

}