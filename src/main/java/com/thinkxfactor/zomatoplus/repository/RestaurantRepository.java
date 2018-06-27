package com.thinkxfactor.zomatoplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Restuarent;
import com.thinkxfactor.zomatoplus.models.User;

public interface RestaurantRepository extends JpaRepository<Restuarent,Long>{
	Restuarent findByNameAndAddress(String name,String address);
}

