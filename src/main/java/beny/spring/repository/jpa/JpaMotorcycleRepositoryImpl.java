package beny.spring.repository.jpa;

import beny.spring.model.MotorcycleData;
import beny.spring.repository.MotorcycleRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Beny on 04.06.2017.
 */

@Repository
public class JpaMotorcycleRepositoryImpl implements MotorcycleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MotorcycleData> getAllMotorcycle() throws DataAccessException {
        Query query = this.em.createQuery("SELECT motorcycle FROM MotorcycleData motorcycle");
        return query.getResultList();
    }

}
