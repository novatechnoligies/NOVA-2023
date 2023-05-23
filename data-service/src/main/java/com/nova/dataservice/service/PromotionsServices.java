package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.Pramotions;
import com.nova.dataservice.entity.Role;

public interface PromotionsServices {

	Pramotions Savepromotion(Pramotions pramotions);

	List<Pramotions> findAllPromotions();

	Optional<Pramotions> getPromotionById(Long id);

	

	

}
