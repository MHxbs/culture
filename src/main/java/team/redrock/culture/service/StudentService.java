package team.redrock.culture.service;

import team.redrock.culture.entity.Student;

public interface StudentService {

    Student selectOneByopenid(String openID);
}
