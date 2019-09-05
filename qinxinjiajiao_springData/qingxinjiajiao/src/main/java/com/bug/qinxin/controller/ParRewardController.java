package com.bug.qinxin.controller;

import com.bug.qinxin.service.ParRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class ParRewardController {

    @Autowired
    ParRewardService parRewardService;

    /**
     * 根据家长手机号查询 拥有的奖学券信息表
     */
    @PostMapping("/reward")
    public String money(@RequestParam("phone") String phone) {
      return parRewardService.money(phone);
    }


}
