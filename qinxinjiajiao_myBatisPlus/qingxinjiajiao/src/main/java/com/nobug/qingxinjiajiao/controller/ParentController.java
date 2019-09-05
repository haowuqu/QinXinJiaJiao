/**
 * FileName:   TeacherPro
 * Author:     O了吗
 * Date:       2019/9/3 11:35
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nobug.qingxinjiajiao.bean.Parent;
import com.nobug.qingxinjiajiao.service.ParentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class ParentController {


    @Autowired
    private ParentService parentService;


    /**
     * 登录
     */
    @PostMapping("/par_login")
    public String parLogin(@RequestParam("phone") String phone, @RequestParam("paswd") String password) {

        QueryWrapper<Parent> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Parent::getPhoneNum, phone).eq(Parent::getPassword, password);

        Parent parent = parentService.getOne(queryWrapper);
        if (parent != null) {
            return "success";
        }
        return "failed";
    }

    /**
     * 注册
     */
    @PostMapping("/par_rege")
    public String parRegister(@RequestParam("phone") String phone, @RequestParam("paswd") String password) {
        Parent parent = new Parent(phone, password);
        boolean state = parentService.save(parent);
        if (state) {
            return "success";
        }
        return "failed";
    }


}