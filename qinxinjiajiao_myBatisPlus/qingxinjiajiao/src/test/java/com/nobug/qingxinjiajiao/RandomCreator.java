package com.nobug.qingxinjiajiao;

import com.nobug.qingxinjiajiao.bean.*;
import com.nobug.qingxinjiajiao.mapper.ParentMapper;
import com.nobug.qingxinjiajiao.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * 随机生成老师信息
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomCreator {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ParentOrderService parentOrderService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentMoneyService parentMoneyService;

    @Autowired
    private ParentRewardService parentRewardService;

    private String[] subjects = new String[]{"语文", "数学", "英语", "政治", "地理", "物理", "生物", "化学"};

    private String[] grades = new String[]{"一年级", "二年级", "三年级", "四年级", "五年级", "六年级", "七年级", "八年级", "九年级", "高一", "高二", "高三"};

    private String[] sexs = new String[]{"男", "女"};

    @Test
    public void autoRandomAll() {
        autoRandomParent();
        autoRandomOrder();
        autoRandomTeacher();
        autoRandomMoney();
        autoRandomReward();
    }

    @Test
    public void autoRandomTeacher() {
        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            Teacher teacher = new Teacher(random.nextInt(0x7fffffff) + "", sexs[random.nextInt(sexs.length)], "蔡徐坤" + i, "image" + i, "address" + i, subjects[random.nextInt(subjects.length)], grades[random.nextInt(grades.length)]);
            teacher.setTeachExper("实习两年半的练习生" + i);
            teacherService.save(teacher);
        }
    }

    @Test
    public void autoRandomOrder() {
        parentOrderService.save(new ParentOrder("123", "java编程思想", "1", "98", "已收货"));
        parentOrderService.save(new ParentOrder("123", "ssh框架", "1", "105", "已收货"));
        parentOrderService.save(new ParentOrder("123", "springboot 2.0", "1", "99", "正在发货"));
    }

    @Test
    public void autoRandomParent() {
        parentService.save(new Parent("123", "abc"));
    }

    @Test
    public void autoRandomMoney() {
        parentMoneyService.save(new ParentMoney("123", "666", "200", "68686"));
    }

    @Test
    public void autoRandomReward() {
        parentRewardService.save(new ParentReward("123", "5", "2019-10-2"));
        parentRewardService.save(new ParentReward("123", "10", "2019-10-5"));
        parentRewardService.save(new ParentReward("123", "50", "2019-10-11"));
        parentRewardService.save(new ParentReward("123", "100", "2019-9-20"));
        parentRewardService.save(new ParentReward("123", "60", "2019-11-2"));
    }

}
