package com.examSystem.dao;

import com.examSystem.entity.TrueFalse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrueFalseMapper {
    int deleteByPrimaryKey(Integer tfqId);

    int insert(TrueFalse record);

    TrueFalse selectByPrimaryKey(Integer tfqId);

    List<TrueFalse> selectAll();

    int updateByPrimaryKey(TrueFalse record);
}