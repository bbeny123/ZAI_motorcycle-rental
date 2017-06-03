package beny.spring.service;

import beny.spring.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Beny on 04.06.2017.
 */

@Service
public class ServiceRentImpl implements ServiceRent {

    private RentRepository rentRepository;

    @Autowired
    public ServiceRentImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }
}
