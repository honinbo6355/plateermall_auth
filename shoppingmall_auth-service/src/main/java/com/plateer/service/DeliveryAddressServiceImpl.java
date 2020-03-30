package com.plateer.service;

import com.plateer.DeliveryAddressDao;
import com.plateer.domain.DeliveryAddress;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private DeliveryAddressDao deliveryAddressDao;

    public DeliveryAddressServiceImpl(DeliveryAddressDao deliveryAddressDao){
        this.deliveryAddressDao = deliveryAddressDao;
    }

    @Override
    public void addDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressDao.addDeliveryAddress(deliveryAddress);
    }
}
