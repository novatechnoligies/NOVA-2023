package com.nova.Owner.Dao;

import java.util.List;

import com.nova.Owner.DTO.ShopSummaryByDTO;

public interface ShopSummaryDAO {

	List<ShopSummaryByDTO> getShopSummaryById(Long shop_id);

}
