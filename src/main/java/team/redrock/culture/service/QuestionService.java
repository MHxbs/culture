package team.redrock.culture.service;

import team.redrock.culture.domain.Result;

public interface QuestionService {

    Result getOneById(String openid);

    Result getTenQuestion(String openid);

    Result answerQuestion(int questionID,String answer, String openid);

}
