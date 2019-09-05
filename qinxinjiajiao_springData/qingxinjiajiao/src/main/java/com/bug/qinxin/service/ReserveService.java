package com.bug.qinxin.service;

import com.bug.qinxin.entity.Reserve;
import com.bug.qinxin.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.List;

@Service
public class ReserveService {
    @Autowired
    ReserveRepository reserveRepository;


    public String order( String phone) {
        //构造条件
        Specification<Reserve> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> paretPhone = root.get("paretPhone");
            return cb.equal(paretPhone, phone);
        };
        //查找所有满足条件的
        List<Reserve> reserveList = reserveRepository.findAll(spec);

        if (reserveList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        reserveList.forEach((reserve -> {
            stringBuilder.append(reserve.getSubject()).append(" ")
                    .append(reserve.getTeachName()).append(",");
        }));
        return stringBuilder.toString();
    }



    public String parReserve(String parPhone, String teachPhone, String teachName,  String subject, String date) {
        Reserve reserve = new Reserve(parPhone, teachPhone, teachName, subject, date);
        Reserve storeReserve = reserveRepository.save(reserve);
        if (storeReserve!=null) {
            return "success";
        }
        return "fail";
    }








}
