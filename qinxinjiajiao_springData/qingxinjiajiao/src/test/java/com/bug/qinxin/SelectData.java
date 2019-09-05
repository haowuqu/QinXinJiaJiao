package com.bug.qinxin;

import com.bug.qinxin.entity.Teacher;
import com.bug.qinxin.repository.ParentRepository;
import com.bug.qinxin.repository.TeacherRepository;
import com.bug.qinxin.service.ParentService;
import com.bug.qinxin.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Path;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectData {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ParentService parentService;

    @Test
    public void test_parentRepository(){
        System.out.println(parentService.parLogin("17783649163", "123"));
    }




    @Test
    public void test(){
        String name = "张三";
        //构造条件
        Specification<Teacher> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> teachSub = root.get("teachName");
            return cb.equal(teachSub, name);
        };
        Teacher teacher = teacherRepository.findOne(spec);
        System.out.println(teacher);
    }

    @Test
    public void test02(){
        System.out.println(teacherService.teacherDetail("张三"));
    }
}
