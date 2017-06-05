package beny.spring.service;

import beny.spring.model.MotorcycleData;
import beny.spring.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    private MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Transactional
    @Override
    public Page<MotorcycleData> findAllPageable(Pageable pageable) {
        return motorcycleRepository.findAll(pageable);
    }
}
