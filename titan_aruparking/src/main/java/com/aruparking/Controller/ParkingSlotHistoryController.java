package com.aruparking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingSlotHistoryDTO;
import com.aruparking.service.ParkingSlotHistoryService;
@RestController
public class ParkingSlotHistoryController {
	@Autowired
	ParkingSlotHistoryService parkingSlotHistoryService;
	
    @GetMapping("/pastslot/{id}")
    public 	List<ParkingSlotHistoryDTO> parkingSlotHistory(@PathVariable long id){
     return parkingSlotHistoryService.getSlotHistoryById(id);
     }
    @GetMapping("/acticeslot/{id}")
    public 	List<ParkingSlotHistoryDTO> parkingSlotActiveHistory(@PathVariable long id){
     return parkingSlotHistoryService.getActiveSlotHistory(id);
     }
}

