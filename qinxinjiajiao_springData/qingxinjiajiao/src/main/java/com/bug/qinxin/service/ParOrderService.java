package com.bug.qinxin.service;

import com.bug.qinxin.entity.ParOrder;
import com.bug.qinxin.repository.ParOrderReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.List;

@Service
public class ParOrderService {

    @Autowired
    ParOrderReposirory parOrderReposirory;


    public String order(String phone) {
        //构造条件
        Specification<ParOrder> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> parPhone = root.get("parPhone");
            return cb.equal(parPhone, phone);
        };
        //查找所有满足条件的
        List<ParOrder> parOrderList = parOrderReposirory.findAll(spec);

        if (parOrderList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        parOrderList.forEach((parOrder -> {
            stringBuilder.append(parOrder.getBookname()).append(",")
                    .append(parOrder.getCount()).append(",")
                    .append(parOrder.getPrice()).append(",")
                    .append(parOrder.getState()).append(",");
        }));

        return stringBuilder.toString();
    }

}
