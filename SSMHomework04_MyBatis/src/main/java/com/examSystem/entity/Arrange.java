package com.examSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Arrange {

    private Integer arrId;
    private Integer testId;
    private String scId;
    private String arrName;
    private LocalDateTime arrStart;
    private LocalDateTime arrStop;
    private Integer arrStatus;


}