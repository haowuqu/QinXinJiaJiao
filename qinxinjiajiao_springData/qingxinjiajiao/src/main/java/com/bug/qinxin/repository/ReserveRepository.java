package com.bug.qinxin.repository;

import com.bug.qinxin.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReserveRepository extends JpaRepository<Reserve, Integer>, JpaSpecificationExecutor<Reserve> {
}
