package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.repository.ShopsAvilabilityRepository;
import com.nova.dataservice.repository.SlotAvailabilityRepository;
import com.nova.dataservice.service.ShopsAvilabilityService;

@Service
public class ShopsAvilabilityServiceimpl implements ShopsAvilabilityService {
	
	@Autowired
	ShopsAvilabilityRepository avilabilityRepository;
	
	@Autowired
	SlotAvailabilityRepository slaRepo;
	
	@Override
	public ShopAvalibility saveShopAvailability(ShopAvalibility avalibility) {
		
		LocalDate currentDate =avalibility.getFromDate();
		 while (!currentDate.isAfter(avalibility.getToDate())) {
			 LocalTime currentTime = avalibility.getFromTime();
		        while (!currentTime.isAfter(avalibility.getToTime())) {
		            SlotAvailability sla = new SlotAvailability();
		            sla.setAppDate(currentDate);
		            sla.setAppintmentStatus("OPEN");
		            sla.setIsDeleted(false);
		            sla.setLastUpdate(LocalDate.now());
		            sla.setShopId(avalibility.getShop());
		            sla.setSlotTime(currentTime);
		            sla.setStatus(true);
		            slaRepo.save(sla);
		            currentTime = currentTime.plusMinutes(avalibility.getTimeInterval());
		        }
	            currentDate = currentDate.plusDays(1);
	        }
		
		return avilabilityRepository.save(avalibility) ;
	}

	@Override
	public List<ShopAvalibility> findAllShopAvailability() {
		// TODO Auto-generated method stub
		return avilabilityRepository.findAll();
	}

	@Override
	public Optional<ShopAvalibility> getShopAvaibilityById(Long id) {
		// TODO Auto-generated method stub
		return avilabilityRepository.findById(id);
	}

}
