package team.redrock.culture.service.impl;


import org.springframework.transaction.annotation.Transactional;
import team.redrock.culture.domain.Result;
import team.redrock.culture.domain.ResultEnum;
import team.redrock.culture.entity.Question;
import team.redrock.culture.entity.User;
import team.redrock.culture.mapper.ClazzMapper;
import team.redrock.culture.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.culture.mapper.StudentMapper;
import team.redrock.culture.mapper.UserMapper;
import team.redrock.culture.service.QuestionService;
import team.redrock.culture.util.ResultUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Transactional
    @Override
    public Result getOneById(String openid) {
        User user=userMapper.selectUserByopenid(openid);
        if (user.getLeftTimes()==0){
            return ResultUtil.error(ResultEnum.EMPTYTIMES);
        }

        Random random=new Random();
        int randomId=random.nextInt(822)+1;
        Question question=questionMapper.getOneById(randomId);
        int leftTimes=userMapper.selectLeftTimesByopenid(openid);
        userMapper.updateLeftTimesByopenid(openid,leftTimes-1);
       return ResultUtil.success(question);
    }

    @Transactional
    @Override
    public Result getTenQuestion(String openid) {
        User user=userMapper.selectUserByopenid(openid);
        if (user.getLeftTimes()==0){
            return ResultUtil.error(ResultEnum.EMPTYTIMES);
        }

        Random ran = new Random();
        List<Question> questions=new ArrayList<Question>();
        for (int i=0;i<10;i++){
            Question question=questionMapper.getOneById(ran.nextInt(822)+1);
            questions.add(question);
        }
        int leftTimes=userMapper.selectLeftTimesByopenid(openid);
        userMapper.updateLeftTimesByopenid(openid,leftTimes-1);
        return ResultUtil.success(questions);
    }

    @Transactional
    @Override
    public Result answerQuestion(int questionID, String answer,String openid) {
        String answerFromMysql=questionMapper.getAnswerById(questionID);
        if (answerFromMysql.equals(answer)){
            // 答对后，增加个人答对数
            int personalAmount=userMapper.selectPersonalAmountByopenid(openid);
            userMapper.updatePersonalAmountByopenid(openid,personalAmount+1);
            // 答对后，增加班级答对数
            int clazzID=studentMapper.selectClazzIdByopenid(openid);
            int clazzAmount=clazzMapper.selectCalzzAmountByClazzid(clazzID);
            clazzMapper.updateClazzAmountByClazzid(clazzID,clazzAmount+1);
           return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.WRONGANSWER);
        }

    }
}
