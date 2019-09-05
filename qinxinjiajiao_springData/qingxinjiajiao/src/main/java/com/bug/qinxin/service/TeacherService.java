package com.bug.qinxin.service;

import com.bug.qinxin.entity.Teacher;
import com.bug.qinxin.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public String getSelectTeach(String subject,String grade) {
        //构造条件
        Specification<Teacher> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> teachSub = root.get("teachSub");
            Path<Object> teachGrade = root.get("grade");
            Predicate p1 = cb.equal(teachSub, subject);
            Predicate p2 = cb.equal(teachGrade, grade);
            return cb.and(p1, p2);
        };
        //查找所有满足条件的
        List<Teacher> teacherList = teacherRepository.findAll(spec);

        if (teacherList.isEmpty()) {
            return "error";
        }
        StringBuilder stringBuilder = new StringBuilder();
        teacherList.forEach((teacher -> {
            stringBuilder.append(teacher.getTeachName()).append(",");
        }));
        return stringBuilder.toString();
    }




    public String teacher(String subject) {
        //构造条件
        Specification<Teacher> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> teachSub = root.get("teachSub");
            return cb.equal(teachSub, subject);
        };
        //查找所有满足条件的
        List<Teacher> teacherList = teacherRepository.findAll(spec);

        if (teacherList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        teacherList.forEach((teacher -> {
            stringBuilder.append(teacher.getTeachName()).append(",");
        }));
        return stringBuilder.toString();
    }




    public String teacherDetail(@RequestParam("name") String name) {
        //构造条件
        Specification<Teacher> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> teachSub = root.get("teachName");
            return cb.equal(teachSub, name);
        };
        Teacher teacher = teacherRepository.findOne(spec);

        if (teacher == null) {
            return "";
        }
        return teacher.getTeachSex() + "," +
                teacher.getTeachePhonum() + "," +
                teacher.getTeachAddress() + "," +
                teacher.getTeachExper() + ",";
    }




}
