package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;


import com.nova.dataservice.entity.ShopServiceRelation;

public interface ShopServiceRelationServices {

	ShopServiceRelation saveShopServiceRelation(ShopRating serviceRelation);

	List<ShopServiceRelation> findAllShopServiceRelation();

	Optional<ShopServiceRelation> shopServiceRelationfindById(long id);

}
