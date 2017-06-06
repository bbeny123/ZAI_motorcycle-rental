package beny.spring.repository;

import beny.spring.model.RentData;
import org.springframework.dao.DataAccessException;

import java.util.Collection;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */
public interface RentRepository {
    RentData findById(Long id) throws DataAccessException;
    List getActiveRents() throws DataAccessException;
    List getAllRents() throws DataAccessException;
    List getActiveUserRents(Long id) throws DataAccessException;
    List getAllUserRents(Long id) throws DataAccessException;
    void newRent(Long id, Long mtoId) throws DataAccessException;
    void finishRent(Long id) throws DataAccessException;
    void cancelRent(Long id) throws DataAccessException;
}
