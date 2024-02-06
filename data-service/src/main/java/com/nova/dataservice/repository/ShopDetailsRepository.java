package com.nova.dataservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;

@Repository
public interface ShopDetailsRepository extends JpaRepository<ShopDetails,Long> {

	@Query(nativeQuery = true, value ="Select * from shop_details as c where c.shop_name like %:labName%")
	List<ShopDetails> searchLabByNameAndOwner(String labName);

	List<ShopDetails> findByOwnerAndIsDeleted(UserDetails ownerId,Boolean isDeleted);

	Optional<ShopDetails> save(Long shopId);


}
