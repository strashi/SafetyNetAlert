package com.safetynet.alert.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseFire {
	
	private List<Integer> stations = new ArrayList<>();
	private List<PersonWithMedicalRecordDTO> residents = new ArrayList<>();
		
}
