/**
 * FileName:   TeacherController
 * Author:     O了吗
 * Date:       2019/9/3 15:44
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nobug.qingxinjiajiao.bean.Reserve;
import com.nobug.qingxinjiajiao.bean.Teacher;
import com.nobug.qingxinjiajiao.service.ReserveService;
import com.nobug.qingxinjiajiao.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈〉
 *
 * @author O了吗
 * @create 2019/9/3
 * @since 1.0.0
 */
@RestController
@Slf4j
@RequestMapping("/teacher_pro")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/get_select_teach")
    public String getSelectTeach(@RequestParam("subject") String subject, @RequestParam("grade") String grade) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeachSub, subject).eq(Teacher::getGrade, grade);

        List<Teacher> teachers = teacherService.list(queryWrapper);
        if (teachers.isEmpty()) {
            return "error";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Teacher teacher : teachers) {
            stringBuilder.append(teacher.getTeachName()).append(",");
        }
        return stringBuilder.toString();

    }

    @PostMapping("/teacher")
    public String teacher(@RequestParam("subject_name") String subject) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeachSub, subject);
        List<Teacher> teachers = teacherService.list(queryWrapper);
        if (teachers.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Teacher teacher : teachers) {
            stringBuilder.append(teacher.getTeachName()).append(",");
        }
        return stringBuilder.toString();
    }

    @PostMapping("/teacher_detail")
    public String teacherDetail(@RequestParam("name") String name) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Teacher::getTeachName, name);
        Teacher teacher = teacherService.getOne(queryWrapper);
        if (teacher == null) {
            return "";
        }
        return teacher.getTeachSex() + "," +
                teacher.getTeachPhone() + "," +
                teacher.getTeachAddress() + "," +
                teacher.getTeachExper() + ",";
    }


}