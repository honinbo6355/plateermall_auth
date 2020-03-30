package com.plateer.mapper;

import com.plateer.domain.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {
    void add(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> list(String userEmail);
}
