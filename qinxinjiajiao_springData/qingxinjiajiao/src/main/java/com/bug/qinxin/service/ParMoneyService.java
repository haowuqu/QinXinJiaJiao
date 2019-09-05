package com.bug.qinxin.service;

import com.bug.qinxin.entity.ParMoney;
import com.bug.qinxin.repository.ParMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.List;

@Service
public class ParMoneyService {
    @Autowired
    ParMoneyRepository parMoneyRepository;

    public String money(String phone) {
        //构造条件
        Specification<ParMoney> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> phonenum = root.get("phonenum");
            return cb.equal(phonenum, phone);
        };
        //查找所有满足条件的
        List<ParMoney> parMoneyList = parMoneyRepository.findAll(spec);
        if (parMoneyList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        parMoneyList.forEach((parMoney -> {
            stringBuilder.append(parMoney.getParBalance()).append(",")
                    .append(parMoney.getYue()).append(",")
                    .append(parMoney.getJifen()).append(",");
        }));
        return stringBuilder.toString();
    }
}
