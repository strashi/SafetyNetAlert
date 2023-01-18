package com.safetynet.alert.service;

import java.util.List;

import com.safetynet.alert.model.FireStation;
import com.safetynet.alert.model.Person;

public interface FireStationService {
	public FireStation addFireStation(FireStation fireStation);

	public void deleteFireStationByAddress(String address);

	public List<FireStation> saveListFireStations(List<FireStation> list);

	public FireStation getFireStationByAddress(String Address);

	public FireStation updateFireStation(String oldAddress, String newAddress);
	
	public Iterable<String> createListOfPersonsCoveredByOneFireStation(Integer station);

}