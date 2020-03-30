package com.plateer.mapper;

import com.plateer.domain.DeliveryAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {
    void add(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> list(String userEmail);
    void delete(int id);
    void update(DeliveryAddress deliveryAddress);
    void setDefault(int id);
    void setAllDefaultFalse(String userEmail);
}
