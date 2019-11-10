package com.examSystem.dao;

import com.examSystem.entity.Choice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChoiceMapper {
    int deleteByPrimaryKey(Integer cqId);

    int insert(Choice record);

    Choice selectByPrimaryKey(Integer cqId);

    List<Choice> selectAll();

    int updateByPrimaryKey(Choice record);
}