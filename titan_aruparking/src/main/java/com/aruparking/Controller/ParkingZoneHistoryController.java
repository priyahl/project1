package com.aruparking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aruparking.DTO.ParkingHistoryDTO;
import com.aruparking.DTO.ParkingZoneHistoryDTO;
import com.aruparking.service.ParkingHistoryService;
import com.aruparking.service.ParkingZoneHistoryService;
@RestController
public class ParkingZoneHistoryController {
	
	@Autowired
	ParkingZoneHistoryService parkingZoneHistoryService;
	
    @GetMapping("/pastzone/{id}")
    public 	List<ParkingZoneHistoryDTO> parkingZoneHistory(@PathVariable long id){
     return parkingZoneHistoryService.getZoneHistoryById(id);
     }
    @GetMapping("/activezone/{id}")
    public 	List<ParkingZoneHistoryDTO> parkingActiveZoneHistory(@PathVariable long id){
     return parkingZoneHistoryService.getActiveZoneHistory(id);
     }
}
