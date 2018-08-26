package team.redrock.culture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.redrock.culture.domain.Result;
import team.redrock.culture.service.UserService;
import team.redrock.culture.util.ResultUtil;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/userRank")
    public Result selectUserRank(){
        return ResultUtil.success(userService.selectUserRank());
    }


    @PostMapping(value = "/userInfo")
    public Result selectUserInfo(@RequestParam("openID") String openid){
        return ResultUtil.success(userService.selectOneUserByopenid(openid));
    }
}
