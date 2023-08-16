package com.aruparking.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.DTO.ParkingSlotHistoryDTO;
import com.aruparking.DTO.ParkingZoneHistoryDTO;
import com.aruparking.model.ParkingOrder;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingZones;
import com.aruparking.repository.ParkingOrderRepository;
import com.aruparking.repository.ParkingSlotsRepository;
import com.aruparking.service.ParkingSlotHistoryService;
@Service
public class ParkingSlotHistoryServiceImpl implements ParkingSlotHistoryService {

	@Autowired
	ParkingSlotsRepository parkingSlotsRepo;
	
	@Autowired
	ParkingOrderRepository parkingOrderRepo;

	@Override
	public List<ParkingSlotHistoryDTO> getSlotHistoryById(long id) {
		ParkingSlots slots = parkingSlotsRepo.findById(id);
		if (slots != null) {
				
				List<ParkingOrder> order = parkingOrderRepo.findAllByParkingSlotsId(id);
				List<ParkingSlotHistoryDTO> dto = new ArrayList();
				
		        Date dt=new Date();

				for (ParkingOrder parkingOrder : order) {
					ParkingSlotHistoryDTO dto1=new ParkingSlotHistoryDTO();
				
					int time = dt.compareTo(parkingOrder.getParkingEndTime());
					
					if(time>0) {
					dto1.setUserId(parkingOrder.getParkingUser().getId());
					dto1.setSlotId(parkingOrder.getParkingSlots().getId());
					dto1.setZoneId(parkingOrder.getParkingSlots().getParkingZones().getId());
					dto1.setOrderId(parkingOrder.getId());
					dto1.setParkingStartTime(parkingOrder.getParkingStartTime());
					dto1.setParkingEndTime(parkingOrder.getParkingEndTime());
					dto1.setVehicleNo(parkingOrder.getVehicleNo());
				
					dto1.setSlotName(parkingOrder.getParkingSlots().getSlotName());
					dto1.setFeeId(parkingOrder.getParkingFee().getId());
					dto1.setAmount(parkingOrder.getAmount());
					dto1.setPayee("Aru Parking");
					dto1.setTransactionId(parkingOrder.getTransactionId());
					
					dto.add(dto1);
				}
				}
				return dto;
	
		}

		return null;
	}

	@Override
	public List<ParkingSlotHistoryDTO> getActiveSlotHistory(long id) {
		ParkingSlots slots = parkingSlotsRepo.findById(id);
		if (slots != null) {
				
				List<ParkingOrder> order = parkingOrderRepo.findAllByParkingSlotsId(id);
				List<ParkingSlotHistoryDTO> dto = new ArrayList();
				
		        Date dt=new Date();

				for (ParkingOrder parkingOrder : order) {
					ParkingSlotHistoryDTO dto1=new ParkingSlotHistoryDTO();
				
					int time = dt.compareTo(parkingOrder.getParkingEndTime());
					
					if(time<0) {
					dto1.setUserId(parkingOrder.getParkingUser().getId());
					dto1.setSlotId(parkingOrder.getParkingSlots().getId());
					dto1.setZoneId(parkingOrder.getParkingSlots().getParkingZones().getId());
					dto1.setOrderId(parkingOrder.getId());
					dto1.setParkingStartTime(parkingOrder.getParkingStartTime());
					dto1.setParkingEndTime(parkingOrder.getParkingEndTime());
					dto1.setVehicleNo(parkingOrder.getVehicleNo());
				
					dto1.setSlotName(parkingOrder.getParkingSlots().getSlotName());
					dto1.setFeeId(parkingOrder.getParkingFee().getId());
					dto1.setAmount(parkingOrder.getAmount());
					dto1.setPayee("Aru Parking");
					dto1.setTransactionId(parkingOrder.getTransactionId());
					
					dto.add(dto1);
				}
				}
				return dto;
	
		}
		return null;
	}

}
