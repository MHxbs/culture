package team.redrock.culture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.redrock.culture.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import team.redrock.culture.domain.ResultEnum;
import team.redrock.culture.service.QuestionService;
import team.redrock.culture.util.ResultUtil;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/question")
    public Result getOneQuestion(@RequestParam("openID") String openid){
        return questionService.getOneById(openid);
    }

    @PostMapping(value = "/questions")
    public Result getTenQuestion(@RequestParam("openID") String openid){
        return questionService.getTenQuestion(openid);
    }

    @PostMapping(value = "/answerQuestion")
    public Result answerQusetion(@RequestParam("questionID") int questionID ,
                                    @RequestParam("answer") String answer,
                                    @RequestParam("openID") String openid){
        if (questionID<1 || questionID>822){
            return ResultUtil.error(ResultEnum.PARAERRO);
        }

        return  questionService.answerQuestion(questionID,answer,openid);
    }
}
