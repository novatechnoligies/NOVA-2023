package com.nova.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> findByEmail(String email);

	Optional<UserDetails> findByPhone(String phone);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);

	@Query(value="SELECT sla.app_date As appoinmentDate,sla.slot_time As appoinmentTime,sla.id As slotId,sla.appointment_status As appoinmentStatus,\r\n"
			+ " sd.shop_name as shopName,sd.shop_address as shopAddress,sd.phone as shopPhone,sd.latitude as latitude,sd.longitude as longitude,\r\n"
			+ " con.id as consumerId,con.username as consumerName,con.phone as consumerPhone,\r\n"
			+ " own.id as onwerId,own.username as ownerName,own.phone as ownerPhone\r\n"
			+ " FROM slot_availibility as sla\r\n"
			+ " join shop_details as sd on sd.id=sla.shop_id \r\n"
			+ " join user_details as con on con.id= sla.user_id\r\n"
			+ " join user_details as own on own.id=sd.user_id",nativeQuery = true)
	List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

	

	

	

}
