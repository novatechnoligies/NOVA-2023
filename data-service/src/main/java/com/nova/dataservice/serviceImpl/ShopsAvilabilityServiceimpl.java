package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ShopAvalibilityDTO;
import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.entity.ShopDetails;
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

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ShopAvalibility saveShopAvailability(ShopAvalibility avalibility) {

		LocalDate currentDate = avalibility.getFromDate();
		while (!currentDate.isAfter(avalibility.getToDate())) {
			if (!avalibility.getHolidays().contains(currentDate.getDayOfWeek().toString())) {
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
			}
			currentDate = currentDate.plusDays(1);
		}

		return avilabilityRepository.save(avalibility);
	}

	@Override
	public List<ShopAvalibility> findAllShopAvailability() {
		return avilabilityRepository.findAll();
	}

	@Override
	public Optional<ShopAvalibilityDTO> getShopAvaibilityById(Long id) {
		ShopAvalibilityDTO shopDetailsDTO = modelMapper.map(avilabilityRepository.findById(id).get(),
				ShopAvalibilityDTO.class);
		return Optional.of(shopDetailsDTO);
	}

	@Override
	public Optional<ShopAvalibilityDTO> getShopAvaibilityByShopId(Long id) {
		ShopDetails shop = new ShopDetails();
		shop.setId(id);
		ShopAvalibilityDTO shopDetailsDTO = modelMapper.map(avilabilityRepository.findFirstByShop(shop).get(),
				ShopAvalibilityDTO.class);
		return Optional.of(shopDetailsDTO);
	}
}


