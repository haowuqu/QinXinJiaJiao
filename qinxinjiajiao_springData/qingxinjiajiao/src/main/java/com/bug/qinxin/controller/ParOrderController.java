package com.bug.qinxin.controller;

import com.bug.qinxin.service.ParOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class ParOrderController {

    @Autowired
    ParOrderService parOrderService;

    /**
     * 根据手机号查找家长订单表
     */
    @PostMapping("/order")
    public String order(@RequestParam("phone") String phone) {
     return parOrderService.order(phone);
    }







}
