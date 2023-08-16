package com.aruparking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingHistoryDTO;
import com.aruparking.DTO.ParkingUserDTO;
import com.aruparking.service.ParkingHistoryService;

@RestController
public class ParkingHistoryController {

	@Autowired
	ParkingHistoryService parkingHistoryService;
	
    @GetMapping("/past/{id}")
    public 	List<ParkingHistoryDTO> getHistoryByUserId(@PathVariable long id){
     return parkingHistoryService.getHistoryById(id);
     }
	
    @GetMapping("/active/{id}")
    public 	List<ParkingHistoryDTO> getActiveHistoryById(@PathVariable long id){
     return parkingHistoryService.getActiveHistoryById(id);
     }
	}
