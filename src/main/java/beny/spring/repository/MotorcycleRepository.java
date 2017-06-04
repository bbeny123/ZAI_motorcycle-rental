package beny.spring.repository;

import beny.spring.model.MotorcycleData;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */
public interface MotorcycleRepository {
    List<MotorcycleData> getAllMotorcycle() throws DataAccessException;
}
