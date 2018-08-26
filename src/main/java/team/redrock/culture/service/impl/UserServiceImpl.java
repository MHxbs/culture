package team.redrock.culture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.culture.entity.User;
import team.redrock.culture.entity.UserRank;
import team.redrock.culture.mapper.UserMapper;
import team.redrock.culture.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertOne(User user) {
        userMapper.insertOne(user);
    }

    @Override
    public String selectNicknameByopenid(String openid) {
        return userMapper.selectNicknameByopenid(openid);
    }

    @Override
    public List<UserRank> selectUserRank() {
        return userMapper.selectUserRank();
    }

    @Override
    public User selectOneUserByopenid(String openid) {
        return userMapper.selectUserByopenid(openid);
    }
}
