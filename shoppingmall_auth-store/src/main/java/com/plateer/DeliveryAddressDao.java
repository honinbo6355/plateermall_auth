package com.plateer;

import com.plateer.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressDao {
    void addDeliveryAddress(DeliveryAddress deliveryAddress);
    List<DeliveryAddress> deliveryAddressList(String userEmail);
    void deleteDeliveryAddress(int id);
    void updateDeliveryAddress(DeliveryAddress deliveryAddress);
    void setDefaultAddress(int id);
    void setAllDefaultFalse(String userEmail);
}
