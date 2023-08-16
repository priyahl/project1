package com.aruparking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aruparking.DTO.ParkingUserVehicleDTO;
import com.aruparking.model.ParkingUser;
import com.aruparking.model.ParkingUserVehicle;

public interface ParkingUserVehicleRepository extends JpaRepository<ParkingUserVehicle, Long> {





	public ParkingUserVehicle findByParkingUserIdAndVehicleNo(long userId, String vehicleNo);

//	public List<ParkingUserVehicle> findByDefaultVehicle(boolean defaultVehicle);

	public ParkingUserVehicle findById(long id);


	public List<ParkingUserVehicle> findByParkingUserIdAndFavVehicle(long id, boolean b);

	public List<ParkingUserVehicle> findByParkingUserId( long id);


	public List<ParkingUserVehicle> findByParkingUserIdAndDefaultVehicle(long userId, boolean defaultVehicle);


}
