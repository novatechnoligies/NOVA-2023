package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopRating;
import com.nova.dataservice.service.ShopRatingService;

@RestController
public class ShopRatingController {
 
	@Autowired
	ShopRatingService shopRatingService;
	
	@PostMapping(value="saveRating")
	public ResponseEntity<Object> saveRating(@RequestBody  ShopRating shopRating) {
	try {
		 ShopRating  savedData=shopRatingService.saveRating(shopRating);
		 if (savedData !=null) {
			return new ResponseEntity<Object>(savedData,HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Data not saved",HttpStatus.OK);

		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("something went wrong ",HttpStatus.OK);
	}
	}
	
	@GetMapping(value="/findAllShopRating")
	public ResponseEntity<Object> findAllShopRating() {
		try {
			List<ShopRating> data = shopRatingService.findAllShopRataing();
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("not FOund", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("went wrong", HttpStatus.OK);
		}

	}
	
	@GetMapping(value="/getShopRatingById/{prId}")
	public ResponseEntity<Object> getShopRatingById(@PathVariable("prId") long id) {
	try {
	Optional<ShopRating> data = shopRatingService.getShopRatingById(id);
		
		if (data.isPresent()) {
			return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Object>("data Not Found",HttpStatus.OK);

		}

	
	
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("someThing went Wrong",HttpStatus.OK);
	}

}
}
