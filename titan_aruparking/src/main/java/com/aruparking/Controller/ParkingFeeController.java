package com.aruparking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingFeeDTO;
import com.aruparking.service.ParkingFeeService;

@RestController
public class ParkingFeeController {

	@Autowired
	ParkingFeeService parkingFeeService;
	
	@PostMapping("/fee")
	public ParkingFeeDTO addFee(@RequestBody ParkingFeeDTO parkingFee) {
		return parkingFeeService.addParkingFee(parkingFee);
	}
	//get mapping
	@GetMapping("/allfee")
	public List<ParkingFeeDTO> getFeeDetail(){
		return parkingFeeService.getAllFees();
	}
	
}
