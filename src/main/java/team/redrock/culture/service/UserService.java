package team.redrock.culture.service;

import team.redrock.culture.entity.User;
import team.redrock.culture.entity.UserRank;

import java.util.List;

public interface UserService {

    void insertOne(User user);

    String selectNicknameByopenid(String openid);

    List<UserRank> selectUserRank();

    User selectOneUserByopenid(String openid );
}
