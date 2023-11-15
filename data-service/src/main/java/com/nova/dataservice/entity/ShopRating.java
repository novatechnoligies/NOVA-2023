package com.nova.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_rating")
public class ShopRating {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    @Column(name = "id")
	    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "consumer_id")
//    private UserDetails consumer;
//
//    @ManyToOne
//    @JoinColumn(name = "shop_id")
//    private ShopDetails shop;
	    
  @Column(name = "rating")
   private int rating;

   @Column(name = "comment")
   private String comment;
    
   // @Id

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

