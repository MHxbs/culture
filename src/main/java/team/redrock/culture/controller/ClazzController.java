package team.redrock.culture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.redrock.culture.domain.Result;
import team.redrock.culture.service.ClazzService;
import team.redrock.culture.util.ResultUtil;

@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping(value = "/clazzRank")
    public Result selectClazzRank(){
        return ResultUtil.success(clazzService.selcetClazzRank());

    }
}
