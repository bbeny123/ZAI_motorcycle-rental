package beny.spring.repository.jpa;

import beny.spring.model.MotorcycleData;
import beny.spring.model.RentData;
import beny.spring.repository.MotorcycleRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.domain.Pageable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */

@Repository
public abstract class JpaMotorcycleRepositoryImpl implements MotorcycleRepository {

    @PersistenceContext
    private EntityManager em;

}
