package beny.spring.repository;

import beny.spring.model.RentData;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Created by Beny on 04.06.2017.
 */
public interface RentRepository {
    RentData findById(Long id) throws DataAccessException;
    Collection<RentData> getAllRents() throws DataAccessException;
    Collection<RentData> getUserRents(Long id) throws DataAccessException;
    void saveRent(RentData rentData);
    void deleteRent(Long id);
}
