package com.plateer.service;

import com.plateer.DeliveryAddressDao;
import com.plateer.domain.DeliveryAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private DeliveryAddressDao deliveryAddressDao;
    private UserService userService;

    public DeliveryAddressServiceImpl(DeliveryAddressDao deliveryAddressDao, UserService userService){
        this.deliveryAddressDao = deliveryAddressDao;
        this.userService = userService;
    }

    @Override
    public void addDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddress.setUserEmail(userService.getCurrentUserInfo().getEmail());
        deliveryAddressDao.addDeliveryAddress(deliveryAddress);
    }

    @Override
    public List<DeliveryAddress> deliveryAddressList() {
        return deliveryAddressDao.deliveryAddressList(userService.getCurrentUserInfo().getEmail());
    }
}
