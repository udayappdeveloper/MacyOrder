package com.macys.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.macys.dto.OrderStatus;
import com.macys.dto.UpdateOrderDto;
import com.macys.entity.json.OrderMsgJsonEntity;
import com.macys.entity.xml.FulfillmentOrderEntity;
import com.macys.exception.RecordNotFoundException;
import com.macys.repository.JsonMsgRepository;
import com.macys.repository.XmlMsgRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	XmlMsgRepository xmlMsgRepository;

	@Autowired
	JsonMsgRepository jsonMsgRepository;

	@ExceptionHandler(RecordNotFoundException.class)
	@Override
	public ResponseEntity<Boolean> updateXML(UpdateOrderDto updateOrder) {
		try {
			FulfillmentOrderEntity xmlEntity = xmlMsgRepository.getById(updateOrder.getId());
			xmlEntity.setOrderStatus(OrderStatus.valueOf(updateOrder.getStatus().toUpperCase()));
			xmlMsgRepository.save(xmlEntity);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new RecordNotFoundException();
		}

	}

	@ExceptionHandler(RecordNotFoundException.class)
	@Override
	public ResponseEntity<Boolean> updateJSON(UpdateOrderDto updateOrder) {

		try {
			OrderMsgJsonEntity jsonEntity = jsonMsgRepository.getById(updateOrder.getId());
			jsonEntity.setOrderStatus(OrderStatus.valueOf(updateOrder.getStatus().toUpperCase()));
			jsonMsgRepository.save(jsonEntity);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (EntityNotFoundException ex) {
			throw new RecordNotFoundException();
		}
	}

}
