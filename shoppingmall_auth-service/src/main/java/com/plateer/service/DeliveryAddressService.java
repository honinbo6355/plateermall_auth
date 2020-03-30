package com.plateer.service;

import com.plateer.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    void addDeliveryAddress(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> deliveryAddressList();
}
