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
import com.nobug.qingxinjiajiao.bean.ParentReward;
import com.nobug.qingxinjiajiao.service.ParentMoneyService;
import com.nobug.qingxinjiajiao.service.ParentRewardService;
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
public class ParentRewardController {

    @Autowired
    private ParentRewardService parentRewardService;

    @PostMapping("/reward")
    public String money(@RequestParam("phone") String phone) {
        QueryWrapper<ParentReward> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ParentReward::getPhoneNum, phone);
        List<ParentReward> parentOrders = parentRewardService.list(queryWrapper);
        if (parentOrders.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ParentReward p : parentOrders) {
            stringBuilder.append(p.getAccount()).append(",")
                    .append(p.getDate()).append(",");
        }
        return stringBuilder.toString();
    }

}