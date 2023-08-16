package com.aruparking.service;

import java.util.List;

import com.aruparking.DTO.ParkingSlotsDTO;
import com.aruparking.DTO.ParkingUserVehicleDTO;

public interface ParkingUserVehicleService {

public	ParkingUserVehicleDTO addaccount(ParkingUserVehicleDTO parkingUserVehicleDTO);

public ParkingUserVehicleDTO editAccount(ParkingUserVehicleDTO parkingUserVehicleDTO);

public Object removeAcc(long id);

public  List<ParkingUserVehicleDTO> getSavedVehicleById(long id);

public List<ParkingUserVehicleDTO> getFavVehicleById(long id);

public List<ParkingUserVehicleDTO> getDefaultVehicleById(long id);
}




