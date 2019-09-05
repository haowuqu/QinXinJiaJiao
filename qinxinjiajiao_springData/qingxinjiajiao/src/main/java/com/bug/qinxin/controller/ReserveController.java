package com.bug.qinxin.controller;

import com.bug.qinxin.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher_pro")
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    /**
     * 根据家长的手机号查找 家长预约的教师信息
     */
    @PostMapping("/get_order_teach")
    public String order(@RequestParam("phone") String phone) {
        return reserveService.order(phone);
    }


    /**
     * 保存 家长预约的教师信息
     */
    @PostMapping("/par_reserve")
    public String parReserve(@RequestParam("par_phone") String parPhone,
                             @RequestParam("teach_phone") String teachPhone,
                             @RequestParam("teach_name") String teachName,
                             @RequestParam("subject") String subject,
                             @RequestParam("data") String date) {
        return reserveService.parReserve(parPhone, teachPhone, teachName, subject, date);
    }


}
