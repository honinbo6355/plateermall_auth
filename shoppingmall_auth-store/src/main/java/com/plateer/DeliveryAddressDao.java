package com.plateer;

import com.plateer.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressDao {
    void addDeliveryAddress(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> deliveryAddressList(String userEmail);
}
