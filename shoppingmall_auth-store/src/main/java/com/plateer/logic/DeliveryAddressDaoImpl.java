package com.plateer.logic;

import com.plateer.DeliveryAddressDao;
import com.plateer.domain.DeliveryAddress;
import com.plateer.mapper.DeliveryAddressMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryAddressDaoImpl implements DeliveryAddressDao {

    private DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressDaoImpl(DeliveryAddressMapper deliveryAddressMapper){
        this.deliveryAddressMapper = deliveryAddressMapper;
    }

    public void addDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressMapper.add(deliveryAddress);
    }

    public List<DeliveryAddress> deliveryAddressList(String userEmail) {
        return deliveryAddressMapper.list(userEmail);
    }

    public void deleteDeliveryAddress(int id) {
        deliveryAddressMapper.delete(id);
    }

    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressMapper.update(deliveryAddress);
    }

    public void setDefaultAddress(int id) {
        deliveryAddressMapper.setDefault(id);
    }

    public void setAllDefaultFalse(String userEmail) {
        deliveryAddressMapper.setAllDefaultFalse(userEmail);
    }

}
