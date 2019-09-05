package com.bug.qinxin.repository;

import com.bug.qinxin.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParentRepository extends JpaRepository<Parent, Integer> , JpaSpecificationExecutor<Parent> {
}
