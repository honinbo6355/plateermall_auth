package com.plateer.logic;

import com.plateer.DeliveryAddressDao;
import com.plateer.domain.DeliveryAddress;
import com.plateer.mapper.DeliveryAddressMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryAddressDaoImpl implements DeliveryAddressDao {

    private DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressDaoImpl(DeliveryAddressMapper deliveryAddressMapper){
        this.deliveryAddressMapper = deliveryAddressMapper;
    }

    public void addDeliveryAddress(DeliveryAddress deliveryAddress){
        deliveryAddressMapper.addDeliveryAddress(deliveryAddress);
    }

}
