package com.bug.qinxin.repository;

import com.bug.qinxin.entity.ParMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParMoneyRepository extends JpaRepository<ParMoney, Integer>  , JpaSpecificationExecutor<ParMoney> {
}
