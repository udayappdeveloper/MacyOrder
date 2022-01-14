package com.macys.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.macys.dto.UpdateOrderDto;
import com.macys.service.OrderService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	OrderService orderMessageService;

	@Test
	public void updateXmlTest() throws Exception {

		UpdateOrderDto updateOrderDto = mock(UpdateOrderDto.class);
		when(orderMessageService.updateXML(updateOrderDto)).thenReturn(new ResponseEntity<>(true, HttpStatus.OK));

		String orederUpdateString = "{ \r\n" + "\"id\":1,\r\n" + "\"orderstatus\":\"Shipped\"\r\n" + "\r\n" + "} ";

		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/macys/order/updatexml")
				.accept(MediaType.APPLICATION_JSON).content(orederUpdateString).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	@Test
	public void updateJsonTest() throws Exception  {
		
		UpdateOrderDto updateOrderDto = mock(UpdateOrderDto.class);
		when(orderMessageService.updateJSON(updateOrderDto)).thenReturn(new ResponseEntity<>(true, HttpStatus.OK));

		String orederUpdateString = "{ \r\n" + "\"id\":1,\r\n" + "\"orderstatus\":\"Shipped\"\r\n" + "\r\n" + "} ";

		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/macys/order/updatejson")
				.accept(MediaType.APPLICATION_JSON).content(orederUpdateString).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
