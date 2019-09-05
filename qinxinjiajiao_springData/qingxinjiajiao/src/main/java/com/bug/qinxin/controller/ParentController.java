package com.bug.qinxin.controller;

import com.bug.qinxin.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class ParentController {

    @Autowired
    ParentService parentService;

    /**
     * 家长登录
     */
    @PostMapping("/par_login")
    public String parLogin(@RequestParam("phone") String phone, @RequestParam("paswd") String password) {
        return parentService.parLogin(phone,password);
    }

    /**
     * 家长注册
     */
    @PostMapping("/par_rege")
    public String parRegister(@RequestParam("phone") String phone, @RequestParam("paswd") String password) {
        return parentService.parRegister(phone, password);
    }


}
