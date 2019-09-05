package com.bug.qinxin;

import com.bug.qinxin.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    DataSource dataSource;

    @Autowired
    TeacherRepository teacherRepository;


    @Test
    public void contextLoads() {
        System.out.println(dataSource);
    }


    @Test
    public void test(){
        System.out.println(teacherRepository);
    }












}
