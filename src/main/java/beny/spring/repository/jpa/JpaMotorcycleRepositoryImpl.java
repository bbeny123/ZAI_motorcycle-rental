package beny.spring.repository.jpa;

import beny.spring.model.MotorcycleData;
import beny.spring.model.RentData;
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
    public List getAllMotorcycles() throws DataAccessException {
        Query query = this.em.createQuery("SELECT motorcycle FROM MotorcycleData motorcycle");
        return query.getResultList();
    }

    @Override
    public List getAllAvailableMotorcycles() throws DataAccessException {
        List<MotorcycleData> tempList = getAllMotorcycles();
        tempList.removeIf(e -> e.getRent().stream().anyMatch(p -> p.getStatus().equals(RentData.Statuses.ACTIVE)));
        return tempList;
    }

    @Transactional
    @Override
    public void removeMotorcycle(Long id) throws DataAccessException {
        this.em.remove(findById(id));
    }

    @Transactional
    @Override
    public void saveMotorcycle(MotorcycleData motorcycle) throws DataAccessException {
        if (motorcycle.getId() == null) {
            this.em.persist(motorcycle);
        } else {
            if(motorcycle.getPhoto() == null) {
                motorcycle.setPhoto(findById(motorcycle.getId()).getPhoto());
            }
            this.em.merge(motorcycle);
        }
    }

}
