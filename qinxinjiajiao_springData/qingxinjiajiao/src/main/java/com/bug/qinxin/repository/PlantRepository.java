package com.bug.qinxin.repository;

import com.bug.qinxin.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantRepository extends JpaRepository<Plant, Integer> , JpaSpecificationExecutor<Plant> {
}
