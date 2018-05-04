package de.cosmicit.kvr.controller;


import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    public static final String REGISTRATION_URL = "/address/registration";

    final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Address get(@PathVariable("id") Long id){
        return addressService.findById(id);
    }

}
