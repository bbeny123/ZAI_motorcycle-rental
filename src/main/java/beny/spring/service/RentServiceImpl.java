package beny.spring.service;

import beny.spring.model.RentData;
import beny.spring.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */

@Service
public class RentServiceImpl implements RentService {

    private RentRepository rentRepository;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public RentData findById(Long id) throws DataAccessException {
        return rentRepository.findById(id);
    }

    @Override
    public List getActiveRents() throws DataAccessException {
        return rentRepository.getActiveRents();
    }

    @Override
    public List getAllRents() throws DataAccessException {
        return rentRepository.getAllRents();
    }

    @Override
    public List getActiveUserRents(Long id) throws DataAccessException {
        return rentRepository.getActiveUserRents(id);
    }

    @Override
    public List getAllUserRents(Long id) throws DataAccessException {
        return rentRepository.getAllUserRents(id);
    }

    @Transactional
    @Override
    public void newRent(Long id, Long mtoId) throws DataAccessException {
        rentRepository.newRent(id, mtoId);
    }

    @Transactional
    @Override
    public void finishRent(Long id) throws DataAccessException {
        rentRepository.finishRent(id);
    }

    @Transactional
    @Override
    public void cancelRent(Long id) throws DataAccessException {
        rentRepository.cancelRent(id);
    }
}
