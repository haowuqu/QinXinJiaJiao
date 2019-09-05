package com.bug.qinxin.service;

import com.bug.qinxin.entity.ParReward;
import com.bug.qinxin.repository.ParRewardRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.List;

@Service
public class ParRewardService {

    @Autowired
    ParRewardRepoitory parRewardRepoitory;

    public String money(String phone) {
        //构造条件
        Specification<ParReward> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> phonenum = root.get("phonenum");
            return cb.equal(phonenum, phone);
        };
        //查找所有满足条件的
        List<ParReward> parRewardList = parRewardRepoitory.findAll(spec);

        if (parRewardList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        parRewardList.forEach((parReward -> {
            stringBuilder.append(parReward.getAcount()).append(",")
                    .append(parReward.getData()).append(",");
        }));
        return stringBuilder.toString();
    }


}
