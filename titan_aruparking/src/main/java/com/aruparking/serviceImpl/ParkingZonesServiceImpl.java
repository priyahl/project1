package com.aruparking.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aruparking.DTO.ParkingZonesDTO;
import com.aruparking.model.ParkingZones;
import com.aruparking.repository.ParkingZonesRepository;
import com.aruparking.service.ParkingZonesService;

@Service
public class ParkingZonesServiceImpl implements ParkingZonesService {

	@Autowired
	private ParkingZonesRepository parkingZonesRepository;
	/*
	 * public ParkingZonesServiceImpl(ParkingZonesRepository parkingZonesRepository)
	 * { this.parkingZonesRepository = parkingZonesRepository; }
	 */

	@Override
	public ParkingZonesDTO createParkingZone(ParkingZonesDTO parkingZonesDto) {

		// copying data from dto to entity
		ParkingZones pz = new ParkingZones();
		pz.setZoneName(parkingZonesDto.getZoneName());
		pz.setStatus(parkingZonesDto.getStatus());
		pz.setCreatedOn(parkingZonesDto.getCreatedOn());
		pz.setUpdatedOn(parkingZonesDto.getUpdatedOn());

		ParkingZones newZones = parkingZonesRepository.save(pz);

		// convert entity to dto to send it to controller layer
		ParkingZonesDTO dto = new ParkingZonesDTO();
		dto.setId(newZones.getId());
		dto.setZoneName(newZones.getZoneName());
		dto.setStatus(newZones.getStatus());
		dto.setCreatedOn(newZones.getCreatedOn());
		dto.setUpdatedOn(newZones.getUpdatedOn());
		return dto;
	}

	@Override
	public List<ParkingZonesDTO> getAllZones() {

		// overall we're converting entity to dto

		List<ParkingZones> parkingZones = parkingZonesRepository.findAll();// here we are getting data in the form of
																			// entity

		List<ParkingZonesDTO> dto = new ArrayList<>();

		for (ParkingZones getAllZones : parkingZones) {
			ParkingZonesDTO pz = new ParkingZonesDTO();
			pz.setId(getAllZones.getId());
			pz.setZoneName(getAllZones.getZoneName());
			pz.setStatus(getAllZones.getStatus());
			pz.setCreatedOn(getAllZones.getCreatedOn());
			pz.setUpdatedOn(getAllZones.getUpdatedOn());

			dto.add(pz);
		}
		return dto;
	}

	@Override
	public ParkingZonesDTO getZoneById(long id) {
		ParkingZones pz = parkingZonesRepository.findById(id);
//		ParkingZones pz = getOneZone.get();
		ParkingZonesDTO pzDto = new ParkingZonesDTO();

		pzDto.setId(pz.getId());
		pzDto.setZoneName(pz.getZoneName());
		pzDto.setStatus(pz.getStatus());
		pzDto.setCreatedOn(pz.getCreatedOn());
		pzDto.setUpdatedOn(pz.getUpdatedOn());
		return pzDto;
	}

	@Override
	public ParkingZonesDTO updateZone(ParkingZonesDTO parkingZonesDTO) {

		ParkingZones pz = parkingZonesRepository.findById(parkingZonesDTO.getId());
//		ParkingZones pz = optional.get();
		if(pz != null) {
		pz.setZoneName(parkingZonesDTO.getZoneName());
		pz.setStatus(parkingZonesDTO.getStatus());

		ParkingZones p = parkingZonesRepository.save(pz);
		return update(p);
		}else {
			throw new RuntimeException("ID IS NOT PRESENT");
		}
	}
	public ParkingZonesDTO update(ParkingZones p) {
		ParkingZonesDTO dto = new ParkingZonesDTO();
		dto.setId(p.getId());
		dto.setZoneName(p.getZoneName());
		dto.setStatus(p.getStatus());
		dto.setCreatedOn(p.getCreatedOn());
		dto.setUpdatedOn(p.getUpdatedOn());
		
		return dto;
	}

}
