package team.redrock.culture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.culture.entity.Student;
import team.redrock.culture.mapper.StudentMapper;
import team.redrock.culture.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectOneByopenid(String openID) {
        return studentMapper.selectOneByopenid(openID);
    }
}
