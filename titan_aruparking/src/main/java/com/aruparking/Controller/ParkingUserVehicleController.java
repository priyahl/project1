package com.aruparking.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingSlotsDTO;
import com.aruparking.DTO.ParkingUserVehicleDTO;
import com.aruparking.DTO.ParkingZonesDTO;
import com.aruparking.service.ParkingUserVehicleService;

@RestController
public class ParkingUserVehicleController {
	
	@Autowired
	private ParkingUserVehicleService parkingUserVehicleService;
	
	@PostMapping("/addacc")
	ParkingUserVehicleDTO addaccount(@RequestBody ParkingUserVehicleDTO parkingUserVehicleDTO) {
		return parkingUserVehicleService.addaccount(parkingUserVehicleDTO);
	}
	
	
	@PutMapping("/updateacc")
	ParkingUserVehicleDTO editAccount(@RequestBody ParkingUserVehicleDTO parkingUserVehicleDTO) {
		return parkingUserVehicleService.editAccount(parkingUserVehicleDTO);
	}

	

	@DeleteMapping("/delete/{id}")
	public Object removeAcc(@PathVariable long id) {
		return parkingUserVehicleService.removeAcc(id);
	}

	@GetMapping("/getsave/{id}")
	public List<ParkingUserVehicleDTO> getSavedVehicleById(@PathVariable long id) {
	    return parkingUserVehicleService.getSavedVehicleById(id);
	}
	
	@GetMapping("/getfav/{id}")
	public List<ParkingUserVehicleDTO> getFavVehicleById(@PathVariable long id) {
	    return parkingUserVehicleService.getFavVehicleById(id);
	}
	
	@GetMapping("/getdefault/{id}")
	public List<ParkingUserVehicleDTO> getDefaultVehicleById(@PathVariable long id) {
	    return parkingUserVehicleService.getDefaultVehicleById(id);
	}
}
