package com.macys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macys.entity.json.OrderMsgJsonEntity;

public interface JsonMsgRepository extends JpaRepository<OrderMsgJsonEntity, Integer> {
}