package team.redrock.culture.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.redrock.culture.entity.User;
import team.redrock.culture.entity.UserRank;

import java.util.List;

public interface UserMapper {

    @Insert("insert into userInfo (openid,nickname,sex,headimgurl,personalAmount,leftTimes,college) " +
            "    values (#{openid},#{nickname},#{sex},#{headimgurl},#{personalAmount},#{leftTimes},#{college}) ")
    void insertOne(User user);

    @Select("select nickname from userInfo where openid=#{openid}")
    String selectNicknameByopenid(String openid);

    @Select("select * from userInfo where openid=#{openid}")
    User selectUserByopenid(String openid);

    @Update("update userInfo set leftTimes= #{leftTimes} where openid=#{openid}")
    void updateLeftTimesByopenid(@Param("openid") String openid, @Param("leftTimes") int leftTimes);

    @Select("select leftTimes from userInfo where openid=#{openid}")
    int selectLeftTimesByopenid(String openid);

    @Update("update userInfo set personalAmount= #{personalAmount} where openid= #{openid}")
    void updatePersonalAmountByopenid(@Param("openid") String openid,@Param("personalAmount") int personalAmount);

    @Select("select personalAmount from userInfo where openid=#{openid}")
    int selectPersonalAmountByopenid(String openid);

    @Select("SELECT p.*, @curRank := @curRank + 1 AS rank\n" +
            "FROM userInfo p, (\n" +
            "SELECT @curRank := 0\n" +
            ") q\n" +
            "ORDER BY personalAmount desc limit 30;")
    List<UserRank> selectUserRank();

}