/**
 * FileName:   ParentMoneyController
 * Author:     O了吗
 * Date:       2019/9/3 18:45
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nobug.qingxinjiajiao.bean.ParentMoney;
import com.nobug.qingxinjiajiao.bean.ParentOrder;
import com.nobug.qingxinjiajiao.service.ParentMoneyService;
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
public class ParentMoneyController {

    @Autowired
    private ParentMoneyService parentMoneyService;

    @PostMapping("/money")
    public String money(@RequestParam("phone") String phone) {
        QueryWrapper<ParentMoney> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ParentMoney::getPhoneNum, phone);
        List<ParentMoney> parentOrders = parentMoneyService.list(queryWrapper);
        if (parentOrders.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ParentMoney p : parentOrders) {
            stringBuilder.append(p.getParentBalance()).append(",")
                    .append(p.getYue()).append(",")
                    .append(p.getJifen()).append(",");
        }
        return stringBuilder.toString();
    }

}