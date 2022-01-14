package com.macys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macys.entity.xml.FulfillmentOrderEntity;

public interface XmlMsgRepository extends JpaRepository<FulfillmentOrderEntity, Integer> {
}