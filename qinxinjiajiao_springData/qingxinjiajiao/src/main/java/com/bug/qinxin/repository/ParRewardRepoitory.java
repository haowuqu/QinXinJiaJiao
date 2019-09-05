package com.bug.qinxin.repository;

import com.bug.qinxin.entity.ParReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParRewardRepoitory extends JpaRepository<ParReward, Integer> , JpaSpecificationExecutor<ParReward> {
}
