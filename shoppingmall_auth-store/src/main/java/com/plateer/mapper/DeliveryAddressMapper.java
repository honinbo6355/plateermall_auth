package com.plateer.mapper;

import com.plateer.domain.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryAddressMapper {
    void addDeliveryAddress(DeliveryAddress deliveryAddress);
}
