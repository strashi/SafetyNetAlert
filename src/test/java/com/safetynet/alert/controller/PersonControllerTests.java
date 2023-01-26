package com.safetynet.alert.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alert.dto.ResponseChildAlert;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.PersonService;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PersonService personService;

	@Test
	public void testAddPerson() throws Exception {
		Person person = new Person();

		mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(person))).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testUpDatePerson() throws Exception {
		/*long id=0L;
		Person person = new Person(id,"Jack","Black","Blv Av","Moscou",112233,"052156","mail@box.xyz");
		Person updatedperson = new Person(id,"Jack","Black","Ruelle","Mauleon",552251,"123","mail@box.xyz");
		when(personService.updatePerson(updatedperson)).thenReturn(updatedperson);
		*/
		Person updatedperson = new Person();

		mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(updatedperson))).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testDeletePerson() throws Exception {
				
		String firstName = "firstName";
		String lastName = "lastName";
		
		mockMvc.perform(delete("/person").param(firstName, firstName).param(lastName, lastName)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testlistOfEmailByCity() throws Exception {
		String city ="city";
		String mail[] = new String[] {"mail","mail2","mail3"};
		List<String> list = new ArrayList<>();
		list.add("mail");
		list.add("mail2");
		list.add("mail3");
		when(personService.listOfEmailByCity(city)).thenReturn(list);
		mockMvc.perform(get("/communityEmail").param(city,city)).andExpect(status().isOk())
		.andExpect(jsonPath("$.Body[0]").value("mail"))
		.andDo(print());
	}
	
	@Test
	public void testChildAlert() throws Exception {
		ResponseChildAlert response = new ResponseChildAlert();
		String address = "address";
		when(personService.childAlert(address)).thenReturn(response);
		
		mockMvc.perform(get("/childAlert").param(address, address)).andExpect(status().isOk()).andDo(print());
	}
}