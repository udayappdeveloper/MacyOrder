package com.macys.util;


import org.modelmapper.ModelMapper;

import com.macys.dto.json.OrderMessageJson;
import com.macys.dto.xml.FulfillmentOrder;
import com.macys.entity.json.OrderMsgJsonEntity;
import com.macys.entity.xml.FulfillmentOrderEntity;

public class EntityToPojoConverter {

    public static OrderMessageJson jsonEntityToPojo(ModelMapper modelMapper, OrderMsgJsonEntity orderMessageJsonEntity) {
        return modelMapper.map(orderMessageJsonEntity, OrderMessageJson.class);
    }

    public static OrderMsgJsonEntity jsonPojoToEntity(ModelMapper modelMapper, OrderMessageJson orderMessageJson) {
        return modelMapper.map(orderMessageJson, OrderMsgJsonEntity.class);
    }

    public static FulfillmentOrderEntity xmlPojoToEntity(ModelMapper modelMapper, FulfillmentOrder fulfillmentOrder) {
        return modelMapper.map(fulfillmentOrder, FulfillmentOrderEntity.class);
    }

    public static FulfillmentOrder xmlEntityToPojo(ModelMapper modelMapper, FulfillmentOrderEntity fulfillmentOrderEntity) {
        return modelMapper.map(fulfillmentOrderEntity, FulfillmentOrder.class);
    }
}
