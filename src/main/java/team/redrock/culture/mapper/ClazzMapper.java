package team.redrock.culture.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.redrock.culture.entity.ClazzRank;

import java.util.List;

public interface ClazzMapper {

    @Select("select clazzAmount from clazz where clazzID=#{clazzid}")
    int selectCalzzAmountByClazzid(int clazzID);

    @Update("update clazz set clazzAmount=#{clazzAmount} where clazzID=#{clazzID}")
    void updateClazzAmountByClazzid(@Param("clazzID") int clazzID, @Param("clazzAmount") int clazzAmount);

    @Select("SELECT p.*, @curRank := @curRank + 1 AS rank\n" +
            "        FROM clazz p, (\n" +
            "        SELECT @curRank := 0\n" +
            "        ) q\n" +
            "        ORDER BY clazzAmount desc limit 30;")
    List<ClazzRank> selectClazzRank();

}
/*
SELECT p.*, @curRank := @curRank + 1 AS rank
           FROM clazz p, (
               SELECT @curRank := 0
               ) q
        ORDER BY clazzAmount desc;*/
