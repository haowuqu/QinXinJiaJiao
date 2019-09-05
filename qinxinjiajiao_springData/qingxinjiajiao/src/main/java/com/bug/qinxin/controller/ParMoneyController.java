package com.bug.qinxin.controller;

import com.bug.qinxin.service.ParMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class ParMoneyController {
    @Autowired
    ParMoneyService parMoneyService;


    /**
     * 根据家长手机号，返回家长钱包信息
     */
    @PostMapping("/money")
    public String money(@RequestParam("phone") String phone) {
      return parMoneyService.money(phone);
    }

}
