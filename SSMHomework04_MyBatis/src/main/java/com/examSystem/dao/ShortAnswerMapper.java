package com.examSystem.dao;

import com.examSystem.entity.ShortAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShortAnswerMapper {
    int deleteByPrimaryKey(Integer saqId);

    int insert(ShortAnswer record);

    ShortAnswer selectByPrimaryKey(Integer saqId);

    List<ShortAnswer> selectAll();

    int updateByPrimaryKey(ShortAnswer record);
}