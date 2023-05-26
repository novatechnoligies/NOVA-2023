package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ShopType;

public interface ShopTypeServices {

	ShopType saveShopType(ShopType shopType);

	List<ShopType> findAllShopType();

	Optional<ShopType> getShopTypeId(Long id);

}
