package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

	Reward findByType(RewardType type);
}
