package com.macys.actuators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.macys.repository.JsonMsgRepository;
import com.macys.repository.XmlMsgRepository;

@Component
public class OrderInfoActuator implements InfoContributor {

	@Autowired
	JsonMsgRepository jsonRepository;

	@Autowired
	XmlMsgRepository xmlRepository;

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("XML Messages Count:", xmlRepository.count())
				.withDetail("Json Messages Count : ", jsonRepository.count()).build();
	}
}
