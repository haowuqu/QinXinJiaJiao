package com.nobug.qingxinjiajiao;

import com.nobug.qingxinjiajiao.mapper.ParentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QingxinjiajiaoApplicationTests {

    @Autowired
    private ParentMapper parentMapper;


    @Test
    public void contextLoads() {
        System.out.println(parentMapper.selectList(null));
    }

}
