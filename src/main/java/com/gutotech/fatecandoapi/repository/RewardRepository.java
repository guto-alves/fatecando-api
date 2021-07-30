package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

	List<Reward> findByUserOrderByDateDesc(User user);

}
