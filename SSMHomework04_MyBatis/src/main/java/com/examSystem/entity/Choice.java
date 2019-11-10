package com.examSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Choice {

    private Integer cqId;
    private String cqContent;
    private String cqA;
    private String cqB;
    private String cqC;
    private String cqD;
    private String cqCorrect;

}