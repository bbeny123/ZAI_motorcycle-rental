package beny.spring.repository;

import beny.spring.model.MotorcycleData;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */
public interface MotorcycleRepository  {
    MotorcycleData findById(Long id) throws DataAccessException;
    List getAllMotorcycle() throws DataAccessException;
    void removeMotorcycle(Long id) throws DataAccessException;
    void saveMotorcycle(MotorcycleData motorcycle) throws DataAccessException;
}
