package team.redrock.culture.service;

import org.apache.ibatis.annotations.Select;
import team.redrock.culture.entity.ClazzRank;

import java.util.List;

public interface ClazzService {


    List<ClazzRank> selcetClazzRank();
}
