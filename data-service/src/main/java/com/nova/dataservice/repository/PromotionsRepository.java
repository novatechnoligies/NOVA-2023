package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.Pramotions;

@Repository
public interface PromotionsRepository extends JpaRepository<Pramotions, Long> {  

}
