package cn.jyuyang.service;

import cn.jyuyang.entity.KaoLa;
import cn.jyuyang.mapper.KaoLaMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaolaService {
    @Autowired
    private KaoLaMapper kaoLaMapper;
    public KaoLa findById(Integer id){
        return  kaoLaMapper.findById(id);
    }
}
