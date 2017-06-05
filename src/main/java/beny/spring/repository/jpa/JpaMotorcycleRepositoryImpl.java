package beny.spring.repository.jpa;

import beny.spring.model.MotorcycleData;
import beny.spring.repository.MotorcycleRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public MotorcycleData findById(Long id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT motorcycle FROM MotorcycleData motorcycle WHERE motorcycle.id = :id");
        query.setParameter("id", id);
        try {
            return (MotorcycleData) query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<MotorcycleData> getAllMotorcycle() throws DataAccessException {
        Query query = this.em.createQuery("SELECT motorcycle FROM MotorcycleData motorcycle");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void removeMotorcycle(Long id) {
        MotorcycleData toRemove = findById(id);
        if(toRemove != null)
            this.em.remove(toRemove);
    }

}
