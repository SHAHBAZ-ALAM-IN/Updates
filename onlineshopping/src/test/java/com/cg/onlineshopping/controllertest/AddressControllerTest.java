package com.cg.onlineshopping.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cg.onlineshopping.controller.AddressController;
import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.modal.AddressDetails;
import com.cg.onlineshopping.modal.CreateAddressRequest;
import com.cg.onlineshopping.service.impl.AddressServiceImpl;
import com.cg.onlineshopping.util.AddressUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.TestUtils;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
@RunWith(SpringRunner.class)
@WebMvcTest(value = AddressController.class)
class AddressControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddressServiceImpl service;
	
	@MockBean
	private AddressUtil addressUtil;
	@BeforeEach
	void setUp() throws Exception {
	}
	

	

}
