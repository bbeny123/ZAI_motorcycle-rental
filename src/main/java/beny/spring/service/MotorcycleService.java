package beny.spring.service;

import beny.spring.model.MotorcycleData;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */
public interface MotorcycleService {
    MotorcycleData findById(Long id) throws DataAccessException;
    List<MotorcycleData> getAllMotorcycle() throws DataAccessException;
    void removeMotorcycle(Long id) throws DataAccessException;
    void saveMotorcycle(MotorcycleData motorcycle) throws DataAccessException;
}
