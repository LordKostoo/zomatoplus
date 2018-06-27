package com.thinkxfactor.zomatoplus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.Restuarent;
import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.ItemRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;
import com.thinkxfactor.zomatoplus.repository.UserRepository;

@RestController
@RequestMapping("/restuarent")
public class RestuarentController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ItemRepository itemRepository;

	@PostMapping("/create")
	public Restuarent createRestuarent(@RequestBody Restuarent res) {
		Restuarent persistedRest = restaurantRepository.save(res);
		return persistedRest;
	}

	@GetMapping("getall")
	public List<Restuarent> ListAllRestuarent() {
		List<Restuarent> listofrests = restaurantRepository.findAll();
		return listofrests;
	}

@PostMapping("/additem")
public Item AddItem(@RequestBody Item items) {
	Item persisteditem=itemRepository.save(items);
	return persisteditem;}

	@PostMapping("/findrest")
	public Restuarent restfind(@RequestBody Restuarent rest) {
		Restuarent persistRest=restaurantRepository.findByNameAndAddress(rest.getName(),rest.getAddress());
		return persistRest;
		}

	@PostMapping("/finditem")
	public Item finditem(@RequestBody Item items) {
		Item persistItem= itemRepository.findByRestaurantIdAndName(items.getRestaurantId(), items.getName());
		return persistItem;
	}

}