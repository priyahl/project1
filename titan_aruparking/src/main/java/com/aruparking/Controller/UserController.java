package com.aruparking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingUserDTO;
import com.aruparking.repository.ParkingUserRepository;
import com.aruparking.service.ParkingUserService;

@RestController
public class UserController {

	@Autowired
	ParkingUserService parkingUserService;
	
	@PostMapping("/adduser")
	public Object addUser(@RequestBody ParkingUserDTO userDTO) {
		return parkingUserService.addUserDetails(userDTO);
	}
}
