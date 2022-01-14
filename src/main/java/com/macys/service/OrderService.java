package com.macys.service;

import org.springframework.http.ResponseEntity;

import com.macys.dto.UpdateOrderDto;

public interface OrderService {
	 ResponseEntity<Boolean> updateXML(UpdateOrderDto updateOrderXmlDto);
	 ResponseEntity<Boolean> updateJSON(UpdateOrderDto updateOrderJSONDto);
}
