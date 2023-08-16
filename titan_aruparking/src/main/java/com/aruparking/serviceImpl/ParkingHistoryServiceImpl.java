package com.aruparking.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.DTO.ParkingHistoryDTO;
import com.aruparking.DTO.ParkingOrderDTO;
import com.aruparking.DTO.ParkingUserDTO;
import com.aruparking.model.ParkingOrder;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingUser;
import com.aruparking.repository.ParkingFeeRepository;
import com.aruparking.repository.ParkingOrderRepository;
import com.aruparking.repository.ParkingSlotsRepository;
import com.aruparking.repository.ParkingUserRepository;
import com.aruparking.repository.ParkingZonesRepository;
import com.aruparking.service.ParkingHistoryService;

@Service
public class ParkingHistoryServiceImpl implements ParkingHistoryService {

	@Autowired
	ParkingUserRepository parkingUserRepo;

	@Autowired
	ParkingSlotsRepository parkingSlotsRepo;

	@Autowired
	ParkingZonesRepository parkingZonesRepo;

	@Autowired
	ParkingFeeRepository parkingFeeRepo;

	@Autowired
	ParkingOrderRepository parkingOrderRepo;

	@Override
	public List<ParkingHistoryDTO> getHistoryById(long id) {

		ParkingUser userId = parkingUserRepo.findById(id);
		Date date = new Date();
		if (userId != null) {

			List<ParkingOrder> order = (List<ParkingOrder>) parkingOrderRepo.findAllByParkingUserId(id);
			List<ParkingHistoryDTO> userDto = new ArrayList();

			for (ParkingOrder p : order) {
				ParkingHistoryDTO dto = new ParkingHistoryDTO();
				int endtime = date.compareTo(p.getParkingEndTime());
				if (endtime > 0) {
					dto.setUserId(p.getParkingUser().getId());
					dto.setZoneId(p.getParkingSlots().getParkingZones().getId());
					dto.setSlotId(p.getParkingSlots().getId());
					dto.setOrderId(p.getId());
					dto.setFeeId(p.getParkingFee().getId());
					dto.setAmount(p.getAmount());
					dto.setParkingStartTime(p.getParkingStartTime());
					dto.setParkingEndTime(p.getParkingEndTime());
					dto.setVehicleNo(p.getVehicleNo());
					dto.setPayee("Aru Parking");
					dto.setTransactionId(p.getTransactionId());
					dto.setSlotName(p.getParkingSlots().getSlotName());
					dto.setTransactionId(p.getTransactionId());

					userDto.add(dto);
				}
			}
			return userDto;
		} else {
			throw new RuntimeException("user id is not present.");
		}

	}

	@Override
	public List<ParkingHistoryDTO> getActiveHistoryById(long id) {

		ParkingUser userId = parkingUserRepo.findById(id);
		Date date = new Date();
		if (userId != null) {

			List<ParkingOrder> order =  parkingOrderRepo.findAllByParkingUserId(id);
			List<ParkingHistoryDTO> userDto = new ArrayList();

			for (ParkingOrder p : order) {
				ParkingHistoryDTO dto = new ParkingHistoryDTO();
				
				int endtime = date.compareTo(p.getParkingEndTime());
				
				if (endtime < 0) {
					dto.setUserId(p.getParkingUser().getId());
					dto.setZoneId(p.getParkingSlots().getParkingZones().getId());
					dto.setSlotId(p.getParkingSlots().getId());
					dto.setOrderId(p.getId());
					dto.setFeeId(p.getParkingFee().getId());
					dto.setAmount(p.getAmount());
					dto.setParkingStartTime(p.getParkingStartTime());
					dto.setParkingEndTime(p.getParkingEndTime());
					dto.setVehicleNo(p.getVehicleNo());
					dto.setPayee("Aru Parking");
					dto.setTransactionId(p.getTransactionId());
					dto.setSlotName(p.getParkingSlots().getSlotName());
					dto.setTransactionId(p.getTransactionId());

					userDto.add(dto);
				}
			}
			return userDto;
		}
//		} else {
//			throw new RuntimeException("user id is not present.");
//		}

		
		
		return null;
	}

	}
