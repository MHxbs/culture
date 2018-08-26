package team.redrock.culture.mapper;

import org.apache.ibatis.annotations.Select;
import team.redrock.culture.entity.Student;

public interface StudentMapper {

    @Select("select * from stuInfo where openID=#{openID}")
    Student selectOneByopenid(String openID);

    @Select("select clazzID from stuInfo where openID=#{openID}")
    int selectClazzIdByopenid(String openID);
}
