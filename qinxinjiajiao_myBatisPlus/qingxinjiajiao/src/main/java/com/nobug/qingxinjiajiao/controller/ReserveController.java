/**
 * FileName:   PanentOrderController
 * Author:     O了吗
 * Date:       2019/9/3 18:27
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nobug.qingxinjiajiao.bean.ParentOrder;
import com.nobug.qingxinjiajiao.bean.Reserve;
import com.nobug.qingxinjiajiao.service.ParentOrderService;
import com.nobug.qingxinjiajiao.service.ReserveService;
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
public class ReserveController {


    @Autowired
    private ReserveService reserveService;

    @PostMapping("/get_order_teach")
    public String order(@RequestParam("phone") String phone) {
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Reserve::getParentPhone, phone);
        List<Reserve> parentOrders = reserveService.list(queryWrapper);
        if (parentOrders.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Reserve p : parentOrders) {
            stringBuilder.append(p.getSubject()).append(" ")
                    .append(p.getTeachName()).append(",");
        }
        return stringBuilder.toString();
    }

    @PostMapping("/par_reserve")
    public String parReserve(@RequestParam("par_phone") String parPhone, @RequestParam("teach_phone") String teachPhone, @RequestParam("teach_name") String teachName, @RequestParam("subject") String subject, @RequestParam("data") String date) {
        Reserve reserve = new Reserve(parPhone, teachPhone, teachName, subject, date);
        boolean state = reserveService.save(reserve);
        if (state) {
            return "success";
        }
        return "fail";
    }


}