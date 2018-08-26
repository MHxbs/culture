package team.redrock.culture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.redrock.culture.entity.ClazzRank;
import team.redrock.culture.mapper.ClazzMapper;
import team.redrock.culture.service.ClazzService;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<ClazzRank> selcetClazzRank() {
        return clazzMapper.selectClazzRank();
    }
}
