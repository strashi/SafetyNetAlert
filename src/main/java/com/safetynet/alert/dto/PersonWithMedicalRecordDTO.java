package com.safetynet.alert.dto;

import java.util.ArrayList;
import java.util.List;

import com.safetynet.alert.model.Allergie;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Medication;

import lombok.Data;

@Data
public class PersonWithMedicalRecordDTO {
	
	private String firstName;
	private String lastName;
	private String phone;
	private int age;
	//private List<MedicalRecordDTO> medicalRecordDTOList = new ArrayList<>();
	
	List<Medication> medications = new ArrayList<>();
	
	List<Allergie> allergies = new ArrayList<>();

}