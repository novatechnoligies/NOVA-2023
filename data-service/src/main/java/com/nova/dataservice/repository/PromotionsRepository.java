package com.nova.dataservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.Pramotions;

@Repository
public interface PromotionsRepository extends JpaRepository<Pramotions, Long> {

	Optional<Pramotions> findByShopId(Long id);  

}
