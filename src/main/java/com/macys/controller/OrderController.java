package com.macys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macys.dto.UpdateOrderDto;
import com.macys.service.OrderService;

@RestController
@RequestMapping("/macys/order")
public class OrderController {

	@Autowired
	OrderService orderMessageService;

	@PutMapping(value = "/updatexml", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Boolean> updateXml(@RequestBody UpdateOrderDto updateReq) {
		return orderMessageService.updateXML(updateReq);
	}
	
	@PutMapping(value = "/updatejson", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Boolean> updateJSON(@RequestBody UpdateOrderDto updateReq) {
		return orderMessageService.updateJSON(updateReq);
	}
}
