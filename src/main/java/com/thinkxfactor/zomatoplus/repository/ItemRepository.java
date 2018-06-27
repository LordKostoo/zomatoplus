package com.thinkxfactor.zomatoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.User;

public interface ItemRepository extends JpaRepository<Item,Long>{
	Item findByRestaurantIdAndName(Long restaurantId,String name);
}
