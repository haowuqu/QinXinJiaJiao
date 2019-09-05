package com.bug.qinxin.repository;

import com.bug.qinxin.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> , JpaSpecificationExecutor<Teacher> {
}
