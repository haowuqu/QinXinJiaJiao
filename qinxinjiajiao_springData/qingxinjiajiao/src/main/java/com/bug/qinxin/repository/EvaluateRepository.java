package com.bug.qinxin.repository;

import com.bug.qinxin.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EvaluateRepository extends JpaRepository<Evaluate, Integer> , JpaSpecificationExecutor<Evaluate> {
}
