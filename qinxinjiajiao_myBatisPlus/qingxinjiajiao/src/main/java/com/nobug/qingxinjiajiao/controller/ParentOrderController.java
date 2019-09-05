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
import com.nobug.qingxinjiajiao.service.ParentOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
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
public class ParentOrderController {


    @Autowired
    private ParentOrderService parentOrderService;

    @PostMapping("/order")
    public String order(@RequestParam("phone") String phone) {
        QueryWrapper<ParentOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ParentOrder::getParentPhone, phone);
        List<ParentOrder> parentOrders = parentOrderService.list(queryWrapper);
        if (parentOrders.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ParentOrder p : parentOrders) {
            stringBuilder.append(p.getBookName()).append(",")
                    .append(p.getCount()).append(",")
                    .append(p.getPrice()).append(",")
                    .append(p.getState()).append(",");
        }
        return stringBuilder.toString();
    }

}