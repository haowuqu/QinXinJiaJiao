package com.bug.qinxin;

import com.bug.qinxin.entity.*;
import com.bug.qinxin.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertData {

    @Autowired
    EvaluateRepository evaluateRepository;

    /**
     * 存储家长用户表（本应用面对的是家教家长客户端）
     */
    @Autowired
    ParentRepository parentRepository;
    /**
     * 家长钱包信息存储表
     */
    @Autowired
    ParMoneyRepository parMoneyRepository;

    /**
     * 存储家长用户表（本应用面对的是家教家长客户端）
     */
    @Autowired
    ParOrderReposirory parOrderReposirory;
    /**
     * 拥有的奖学券信息表
     */
    @Autowired
    ParRewardRepoitory parRewardRepoitory;

    /**
     * 个人信息界面学习计划对应的表
     */
    @Autowired
    PlantRepository plantRepository;

    /**
     * 对应家长预约的教师信息
     */
    @Autowired
    ReserveRepository reserveRepository;

    /**
     * 教师信息
     */
    @Autowired
    TeacherRepository teacherRepository;

    /**
     * 插入教师信息
     */
    @Test
    public void test_teacherRepository() {
        Teacher teacher = new Teacher("17783649166", "男", "教师甲", "", "重庆合川", "", "语文", "一年级");
        Teacher teacher02 = new Teacher("17583649566", "男", "教师乙", "", "重庆开州", "", "数学", "高一");
        Teacher teacher03 = new Teacher("17783659166", "男", "教师丙", "", "重庆万州", "", "英语", "高二");
        Teacher teacher04 = new Teacher("17783749166", "男", "教师丁", "", "重庆合川", "", "政治", "高三");
        System.out.println(teacherRepository.save(teacher));
        System.out.println(teacherRepository.save(teacher02));
        System.out.println(teacherRepository.save(teacher03));
        System.out.println(teacherRepository.save(teacher04));
    }


    /**
     * 插入对应家长预约的教师信息
     */
    @Test
    public void test_reserveRepository() {
        Reserve reserve = new Reserve("15486284537", "14785124689", "教师甲", "大学物理", "2019/9/4");
        Reserve reserve02 = new Reserve("15486684537", "14765124689", "教师乙", "大学英语", "2019/8/4");
        Reserve reserve03 = new Reserve("15884284537", "19785128689", "教师丁", "大学体育", "2019/5/4");
        Reserve reserve04 = new Reserve("15436288537", "14765124689", "教师丁", "大学现代", "2019/9/7");

        System.out.println(reserveRepository.save(reserve));
        System.out.println(reserveRepository.save(reserve02));
        System.out.println(reserveRepository.save(reserve03));
        System.out.println(reserveRepository.save(reserve04));
    }

    //Parent parent = new Parent("17783649163","123");
    //System.out.println(parentRepository.save(parent));

    /**
     * 个人信息界面学习计划对应的表
     */
    @Test
    public void tet_plantRepository() {
        Plant plant = new Plant("15486284537", "学完Spring家族", "2019/9/4");
        System.out.println(plantRepository.save(plant));
    }

    /**
     * 拥有的奖学券信息表
     */
    @Test
    public void test_parRewardRepoitory() {
        ParReward parReward = new ParReward("15486284537", "100", "1");
        System.out.println(parRewardRepoitory.save(parReward));
    }

    /**
     * 家长订单表
     */
    @Test
    public void test_parOrderReposirory() {
        ParOrder parOrder = new ParOrder("17783649163", "疯狂JAVA讲义", "5", "100", "否");
        ParOrder parOrder02 = new ParOrder("17783649163", "疯狂Python讲义", "5", "100", "否");
        ParOrder parOrder03 = new ParOrder("17783649163", "疯狂JSON讲义", "10", "500", "是");
        ParOrder parOrder04 = new ParOrder("17783649163", "疯狂XML讲义", "1", "140", "否");
        System.out.println(parOrderReposirory.save(parOrder));
        System.out.println(parOrderReposirory.save(parOrder02));
        System.out.println(parOrderReposirory.save(parOrder03));
        System.out.println(parOrderReposirory.save(parOrder04));
    }

    /**
     * 家长钱包信息存储表
     */
    @Test
    public void test_parMoneyRepository() {
        ParMoney parMoney = new ParMoney("17783649163", "1000", "500", "100");
        System.out.println(parMoneyRepository.save(parMoney));
    }


    /**
     * 存储家长用户表（本应用面对的是家教家长客户端）
     */
    @Test
    public void test_parentRepository(){
        Parent parent = new Parent("17783649163","123");
        System.out.println(parentRepository.save(parent));
    }

}
