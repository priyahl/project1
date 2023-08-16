package com.aruparking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aruparking.model.ParkingOrder;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrder, Long> {

	public List<ParkingOrder> findAllByParkingUserId(long id);

	public List<ParkingOrder> findAllByParkingSlotsParkingZonesId(long id);

	public List<ParkingOrder> findAllByParkingSlotsId(long id);
}
