package com.bug.qinxin.controller;

import com.bug.qinxin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    /**
     * 根据学科和年级查询教师
     */
    @PostMapping("/get_select_teach")
    public String getSelectTeach(@RequestParam("subject") String subject, @RequestParam("grade") String grade) {
        return teacherService.getSelectTeach(subject,grade);
    }


    /**
     * 根据学科查询教师
     */
    @PostMapping("/teacher")
    public String teacher(@RequestParam("subject_name") String subject) {
        return teacherService.teacher(subject);
    }


    /**
     * 根据老师名查询教师相信信息
     */
    @PostMapping("/teacher_detail")
    public String teacherDetail(@RequestParam("name") String name) {
       return teacherService.teacherDetail(name);
    }


}
