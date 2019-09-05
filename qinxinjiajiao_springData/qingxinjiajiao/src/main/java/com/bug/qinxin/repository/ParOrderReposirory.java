package com.bug.qinxin.repository;

import com.bug.qinxin.entity.ParOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParOrderReposirory extends JpaRepository<ParOrder, Integer>  , JpaSpecificationExecutor<ParOrder> {
}
