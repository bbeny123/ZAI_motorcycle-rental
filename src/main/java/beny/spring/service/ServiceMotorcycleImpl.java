package beny.spring.service;

import beny.spring.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Beny on 04.06.2017.
 */

@Service
public class ServiceMotorcycleImpl implements ServiceMotorcycle {

    private MotorcycleRepository motorcycleRepository;

    @Autowired
    public ServiceMotorcycleImpl(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }
}
