package com.aruparking.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aruparking.DTO.ParkingSlotsDTO;
import com.aruparking.DTO.ParkingUserVehicleDTO;
import com.aruparking.model.ParkingSlots;
import com.aruparking.model.ParkingUser;
import com.aruparking.model.ParkingUserVehicle;
import com.aruparking.repository.ParkingUserRepository;
import com.aruparking.repository.ParkingUserVehicleRepository;
import com.aruparking.service.ParkingUserVehicleService;

@Service
public class ParkingUserVehicleServiceImpl implements ParkingUserVehicleService {
	@Autowired
	ParkingUserVehicleRepository parkingUserVehicleRepo;
	@Autowired
	ParkingUserRepository parkingUserRepo;

	@Override
	public ParkingUserVehicleDTO addaccount(ParkingUserVehicleDTO parkingUserVehicleDTO) {

		ParkingUser userid = parkingUserRepo.findById(parkingUserVehicleDTO.getUserId());

		if (userid != null) {
			ParkingUserVehicle uservh = parkingUserVehicleRepo.findByParkingUserIdAndVehicleNo(
					parkingUserVehicleDTO.getUserId(), parkingUserVehicleDTO.getVehicleNo());

			if (uservh == null) {

				ParkingUserVehicle p = new ParkingUserVehicle();

				p.setParkingUser(userid);
				p.setVehicleNo(parkingUserVehicleDTO.getVehicleNo());
				p.setVehicleName(parkingUserVehicleDTO.getVehicleName());
				p.setStatus(1);
				p.setDefaultVehicle(parkingUserVehicleDTO.isDefaultVehicle());
				p.setFavVehicle(parkingUserVehicleDTO.isFavVehicle());

				if (parkingUserVehicleDTO.isDefaultVehicle() == true) {
					List<ParkingUserVehicle> userVehicles = parkingUserVehicleRepo
							.findByParkingUserIdAndDefaultVehicle(parkingUserVehicleDTO.getUserId(),parkingUserVehicleDTO.isDefaultVehicle());
					
					for (ParkingUserVehicle vehicle : userVehicles) {
						vehicle.setDefaultVehicle(false);
						parkingUserVehicleRepo.save(vehicle);
					}

					ParkingUserVehicle vehicle1 = parkingUserVehicleRepo.save(p);
					ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

					dto.setId(vehicle1.getId());
					dto.setUserId(vehicle1.getParkingUser().getId());
					dto.setVehicleNo(vehicle1.getVehicleNo());
					dto.setCreatedOn(vehicle1.getCreatedOn());
					dto.setLastUpdatedOn(vehicle1.getLastUpdatedOn());
					dto.setStatus(vehicle1.getStatus());
					dto.setDefaultVehicle(vehicle1.isDefaultVehicle());
					dto.setFavVehicle(vehicle1.isFavVehicle());
					dto.setVehicleName(vehicle1.getVehicleName());
					return dto;
				} else {

					ParkingUserVehicle vehicle1 = parkingUserVehicleRepo.save(p);
					ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

					dto.setId(vehicle1.getId());
					dto.setUserId(vehicle1.getParkingUser().getId());
					dto.setVehicleNo(vehicle1.getVehicleNo());
					dto.setCreatedOn(vehicle1.getCreatedOn());
					dto.setLastUpdatedOn(vehicle1.getLastUpdatedOn());
					dto.setStatus(vehicle1.getStatus());
					dto.setDefaultVehicle(vehicle1.isDefaultVehicle());
					dto.setFavVehicle(vehicle1.isFavVehicle());
					dto.setVehicleName(vehicle1.getVehicleName());
					return dto;

				}
				
			}else {
				throw new RuntimeException("duplicate no for userid");
			}
		}
			else {
				throw new RuntimeException("userid not present");
			}
		}
//		return null;

	

	@Override
	public ParkingUserVehicleDTO editAccount(ParkingUserVehicleDTO parkingUserVehicleDTO) {
		ParkingUserVehicle p = parkingUserVehicleRepo.findById(parkingUserVehicleDTO.getId());

		if (p != null) {
			ParkingUserVehicle uservh = parkingUserVehicleRepo.findByParkingUserIdAndVehicleNo(
					parkingUserVehicleDTO.getUserId(), parkingUserVehicleDTO.getVehicleNo());

			if (uservh == null) {

				p.setVehicleNo(parkingUserVehicleDTO.getVehicleNo());
				p.setVehicleName(parkingUserVehicleDTO.getVehicleName());
				p.setDefaultVehicle(parkingUserVehicleDTO.isDefaultVehicle());
				p.setFavVehicle(parkingUserVehicleDTO.isFavVehicle());

				if (parkingUserVehicleDTO.isDefaultVehicle() == true) {

					List<ParkingUserVehicle> userVehicles = parkingUserVehicleRepo
							.findByParkingUserIdAndDefaultVehicle(parkingUserVehicleDTO.getUserId(),parkingUserVehicleDTO.isDefaultVehicle());

					for (ParkingUserVehicle vehicle : userVehicles) {
						vehicle.setDefaultVehicle(false);
						parkingUserVehicleRepo.save(vehicle);
					}

					ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

					dto.setId(p.getId());
					dto.setUserId(p.getParkingUser().getId());
					dto.setVehicleNo(p.getVehicleNo());
					dto.setCreatedOn(p.getCreatedOn());
					dto.setLastUpdatedOn(p.getLastUpdatedOn());
					dto.setStatus(p.getStatus());
					dto.setDefaultVehicle(p.isDefaultVehicle());
					dto.setFavVehicle(p.isFavVehicle());
					dto.setVehicleName(p.getVehicleName());
					return dto;
				} else {

					ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

					dto.setId(p.getId());
					dto.setUserId(p.getParkingUser().getId());
					dto.setVehicleNo(p.getVehicleNo());
					dto.setCreatedOn(p.getCreatedOn());
					dto.setLastUpdatedOn(p.getLastUpdatedOn());
					dto.setStatus(p.getStatus());
					dto.setDefaultVehicle(p.isDefaultVehicle());
					dto.setFavVehicle(p.isFavVehicle());
					dto.setVehicleName(p.getVehicleName());
					return dto;

				}
			} else {
				throw new RuntimeException("duplicate vehicle no for userid ");
			}
		}

		return null;
	}

	@Override
	public Object removeAcc(long id) {
		ParkingUserVehicle parkingUserVehicle = parkingUserVehicleRepo.findById(id);
		if (parkingUserVehicle != null) {
			parkingUserVehicle.setStatus(0);
			parkingUserVehicleRepo.save(parkingUserVehicle);
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "deleted successfully");
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "account does not exists");
			return map;
		}
	}
//		return null;

	@Override
	public List<ParkingUserVehicleDTO> getSavedVehicleById(long id) {
		ParkingUser parkingUser = parkingUserRepo.findById(id);
		if (parkingUser != null) {
			List<ParkingUserVehicle> allvehicle = parkingUserVehicleRepo.findByParkingUserId(id);
			List<ParkingUserVehicleDTO> dto1 = new ArrayList<ParkingUserVehicleDTO>();

			for (ParkingUserVehicle vehicle : allvehicle) {
				ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();
				dto.setId(vehicle.getId());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
		        dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setLastUpdatedOn(vehicle.getLastUpdatedOn());
				dto.setUserId(vehicle.getParkingUser().getId());

				dto1.add(dto);
			}
			return dto1;
		} else {
			throw new RuntimeException("user is not present");
		}

	}

	@Override
	public List<ParkingUserVehicleDTO> getFavVehicleById(long id) {
		ParkingUser parkingUser = parkingUserRepo.findById(id);
		if (parkingUser != null) {
			List<ParkingUserVehicle> favVehicles = parkingUserVehicleRepo.findByParkingUserIdAndFavVehicle(id,
					true);
			List<ParkingUserVehicleDTO> dto1 = new ArrayList();

			for (ParkingUserVehicle vehicle : favVehicles) {
				ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

				dto.setId(vehicle.getId());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setLastUpdatedOn(vehicle.getLastUpdatedOn());
//				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setUserId(vehicle.getParkingUser().getId());

				dto1.add(dto);

			}
			return dto1;
		} else {
			throw new RuntimeException("User is not present");

		}
	}

	@Override
	public List<ParkingUserVehicleDTO> getDefaultVehicleById(long id) {
		ParkingUser parkingUser = parkingUserRepo.findById(id);
		if (parkingUser != null) {
			List<ParkingUserVehicle> defaultVehicles = parkingUserVehicleRepo.findByParkingUserIdAndDefaultVehicle(id,
					true);
			List<ParkingUserVehicleDTO> dto1 = new ArrayList();

			for (ParkingUserVehicle vehicle : defaultVehicles) {
				ParkingUserVehicleDTO dto = new ParkingUserVehicleDTO();

				dto.setId(vehicle.getId());
				dto.setVehicleNo(vehicle.getVehicleNo());
				dto.setCreatedOn(vehicle.getCreatedOn());
				dto.setStatus(vehicle.getStatus());
				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setFavVehicle(vehicle.isFavVehicle());
				dto.setVehicleName(vehicle.getVehicleName());
				dto.setLastUpdatedOn(vehicle.getLastUpdatedOn());
//				dto.setDefaultVehicle(vehicle.isDefaultVehicle());
				dto.setUserId(vehicle.getParkingUser().getId());

				dto1.add(dto);

			}
			return dto1;
		} else {
			throw new RuntimeException("User is not present");

		}

	}

}
