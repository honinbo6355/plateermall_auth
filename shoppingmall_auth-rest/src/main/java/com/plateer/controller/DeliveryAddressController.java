package com.plateer.controller;

import com.plateer.domain.DeliveryAddress;
import com.plateer.service.DeliveryAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/address")
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Authorization"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
public class DeliveryAddressController {

    private DeliveryAddressService deliveryAddressService;

    public DeliveryAddressController(DeliveryAddressService deliveryAddressService){
        this.deliveryAddressService = deliveryAddressService;
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody DeliveryAddress deliveryAddress){
        deliveryAddressService.addDeliveryAddress(deliveryAddress);
    }

    @GetMapping("/list")
    public List<DeliveryAddress> listAddress(){
        return deliveryAddressService.deliveryAddressList();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable int id){
        deliveryAddressService.deleteDeliveryAddress(id);
    }

    @PutMapping("/update")
    public void updateAddress(@RequestBody DeliveryAddress deliveryAddress){
        deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @GetMapping("/setDefaultAddr/{id}")
    public void setDefaultAddress(@PathVariable int id){
        deliveryAddressService.setDefaultAddress(id);
    }
}
