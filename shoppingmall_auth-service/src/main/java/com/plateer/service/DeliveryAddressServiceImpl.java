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
        deliveryAddress.setUserEmail(getCurrentUserEmail());
        deliveryAddressDao.addDeliveryAddress(deliveryAddress);
    }

    @Override
    public List<DeliveryAddress> deliveryAddressList() {
        return deliveryAddressDao.deliveryAddressList(getCurrentUserEmail());
    }

    @Override
    public void deleteDeliveryAddress(int id) {
        deliveryAddressDao.deleteDeliveryAddress(id);
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressDao.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public void setDefaultAddress(int id) {
        //현재 로그인한 유저 배송지 목록의 모든 항목 isDefault를 false로 세팅한다.
        deliveryAddressDao.setAllDefaultFalse(getCurrentUserEmail());
        //들어온 id값의 항목만 true로 세팅한다.
        deliveryAddressDao.setDefaultAddress(id);
    }

    private String getCurrentUserEmail(){
        return userService.getCurrentUserInfo().getEmail();
    }
}
