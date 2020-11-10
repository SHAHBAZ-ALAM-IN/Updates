package com.cg.onlineshopping.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.exception.AddressAlreadyExistsException;
import com.cg.onlineshopping.exception.AddressNotFoundException;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.service.impl.AddressServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class AddressServiceTest {
	@Autowired
	private AddressServiceImpl service;

	@MockBean
	private IAddressRepository repo;
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	 void testCreateAddress() throws AddressAlreadyExistsException {

		Address add = new Address();
		add.setStreetNo("15th");
		add.setBuildingName("Asian");
		add.setCity("hissar");
		add.setState("Haryana");
		add.setCountry("India");
		add.setPincode("122022");

		Mockito.when(repo.save(add)).thenReturn(add);
		assertThat(service.addAddress(add)).isEqualTo(add);

	}
	@Test
	void testGetAddress() throws AddressNotFoundException {

		Address add = new Address();
		add.setAddressId(1);
		add.setStreetNo("15th");
		add.setBuildingName("Asian");
		add.setCity("hissar");
		add.setState("Haryana");
		add.setCountry("India");
		add.setPincode("122022");

		Optional<Address> oAdd = Optional.of(add);
		Mockito.when(repo.findById(1)).thenReturn(oAdd);
		assertThat(service.viewAddress(1)).isEqualTo(oAdd.get());

	}
	@Test
	void testGetAllAddress() {

		Address add = new Address();
		add.setStreetNo("15th");
		add.setBuildingName("Asian");
		add.setCity("hissar");
		add.setState("Haryana");
		add.setCountry("India");
		add.setPincode("122022");

		Address add2 = new Address();
		add2.setStreetNo("10th");
		add2.setBuildingName("Gandhi");
		add2.setCity("Gurgaon");
		add2.setState("Haryana");
		add2.setCountry("India");
		add2.setPincode("122121");

		List<Address> listAdd = new ArrayList<>();
		listAdd.add(add);
		listAdd.add(add2);
		Mockito.when(repo.findAll()).thenReturn(listAdd);
		assertThat(service.viewAllAddress()).isEqualTo(listAdd);
	}
	
	@Test
	void testUpdateEmployee() throws AddressNotFoundException {
		Address add = new Address();
		add.setAddressId(1);
		add.setStreetNo("15th");
		add.setBuildingName("Asian");
		add.setCity("hissar");
		add.setState("Haryana");
		add.setCountry("India");
		add.setPincode("122022");
		Optional<Address> oAdd = Optional.of(add);
		Mockito.when(repo.findById(1)).thenReturn(oAdd);
		oAdd.get().setCountry("AMERICA");
		Mockito.when(repo.findById(1)).thenReturn(oAdd);
		assertThat(service.viewAddress(1).getCountry()).isEqualTo("AMERICA");

	}
	
	@Test
	public void testDeleteEmployee() {
		Address add = new Address();
		add.setAddressId(1);
		add.setStreetNo("15th");
		add.setBuildingName("Asian");
		add.setCity("hissar");
		add.setState("Haryana");
		add.setCountry("India");
		add.setPincode("122022");

		Mockito.when(repo.findById(1)).thenReturn(Optional.of(add));
		Mockito.when(repo.existsById(add.getAddressId())).thenReturn(false);

		assertFalse(repo.existsById(add.getAddressId()));
	}

}
