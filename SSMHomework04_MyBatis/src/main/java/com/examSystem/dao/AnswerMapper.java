package com.examSystem.dao;

import com.examSystem.entity.Answer;
import com.examSystem.entity.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int delBysAccount(String Account);

    int insert(Answer record);

    int addGrade(@Param("answId") int answId,@Param("Sum") float Sum);

    Answer selectByPrimaryKey(Integer answerId);

    List<Answer> selectAll();

    List<Answer> selCorTest();//查询所有待批改试卷

    int updateByPrimaryKey(Answer record);

    List<Answer> selectBySAccount(@Param("sAccount") String sAccount);

    List<Result> selectResult(@Param("sAccount") String sAccount);
}