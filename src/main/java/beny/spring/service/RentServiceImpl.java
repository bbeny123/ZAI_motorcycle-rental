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
    public Collection<RentData> getAllRents() throws DataAccessException {
        List<RentData> a = (List) rentRepository.getAllRents();
        for (RentData b : a) {
            System.out.println(b.getId());
        }
        return rentRepository.getAllRents();
    }

    @Override
    public Collection<RentData> getUserRents(Long id) throws DataAccessException {
        return rentRepository.getUserRents(id);
    }

    @Override
    @Transactional
    public void saveRent(RentData rentData) {
        rentRepository.saveRent(rentData);
    }

    @Override
    public void deleteRent(Long id) {
        rentRepository.deleteRent(id);
    }
}
