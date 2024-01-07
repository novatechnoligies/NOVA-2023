package com.nova.dataservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.ShopAvalibilityDTO;
import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.entity.ShopDetails;


@Repository
public interface ShopsAvilabilityRepository extends JpaRepository<ShopAvalibility, Long> {

	Optional<ShopAvalibilityDTO> findFirstByShop(ShopDetails shop);

	Optional<ShopAvalibility> findByShop(ShopDetails shop);

}
