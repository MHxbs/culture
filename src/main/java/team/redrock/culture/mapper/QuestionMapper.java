package team.redrock.culture.mapper;


import org.apache.ibatis.annotations.Select;

import team.redrock.culture.entity.Question;

public interface QuestionMapper {

    @Select("select * from question where questionID=#{id}")
    Question getOneById(int id);

    @Select("select answer from question where questionID=#{id}")
    String getAnswerById(int id);
}
