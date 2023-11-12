package com.nova.dataservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class ShopRatingDTO {

    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "consumer_id")
//    private UserDetails consumer;
//
//    @ManyToOne
//    @JoinColumn(name = "shop_id")
//    private ShopDetails shop;
//
   private int rating;

    private String comment;
    // Add other fields and getters/setters
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
}

