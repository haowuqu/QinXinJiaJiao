package com.bug.qinxin.service;

import com.bug.qinxin.entity.Parent;
import com.bug.qinxin.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;


    public String parLogin(String phone, String password) {
        //构造条件
        Specification<Parent> spec = (root, query, cb) -> {
            //1.获取比较的属性
            Path<Object> phonenum = root.get("phonenum");
            Path<Object> paswd = root.get("paswd");

            Predicate p1 = cb.equal(phonenum, phone);
            Predicate p2 = cb.equal(paswd, password);
            return cb.and(p1, p2);
        };
        //查找所有满足条件的
        Parent parent = parentRepository.findOne(spec);
        if (parent != null) {
            return "success";
        }
        return "failed";
    }



    public String parRegister(String phone,String password) {
        Parent storeParent = new Parent(phone, password);
        Parent reParent = parentRepository.save(storeParent);
        if (reParent!=null) {
            return "success";
        }
        return "failed";
    }
}
