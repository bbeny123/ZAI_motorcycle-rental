package beny.spring.repository.jpa;

import beny.spring.model.MotorcycleData;
import beny.spring.model.RentData;
import beny.spring.model.UserData;
import beny.spring.repository.RentRepository;
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
public class JpaRentRepositoryImpl implements RentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RentData findById(Long id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent WHERE rent.id = :id");
        query.setParameter("id", id);
        try {
            return (RentData) query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List getActiveRents() throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent WHERE rent.status = 'Active'");
        return query.getResultList();
    }

    @Override
    public List getAllRents() throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent");
        return query.getResultList();
    }

    @Override
    public List getAllUserRents(Long id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent WHERE rent.user.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List getActiveUserRents(Long id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent WHERE rent.user.id = :id AND rent.status = 'Active'");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void newRent(Long id, Long mtoId) throws DataAccessException {
        RentData rentData = new RentData();
        rentData.setMotorcycle(new MotorcycleData());
        rentData.getMotorcycle().setId(mtoId);
        rentData.setUser(new UserData());
        rentData.getUser().setId(id);
        rentData.setStatus(RentData.Statuses.ACTIVE);
        this.em.persist(rentData);
    }

    @Transactional
    @Override
    public void finishRent(Long id) throws DataAccessException {
        RentData rentData = findById(id);
        rentData.setStatus(RentData.Statuses.FINISHED);
        this.em.merge(rentData);
    }

    @Transactional
    @Override
    public void cancelRent(Long id) throws DataAccessException {
        RentData rentData = findById(id);
        rentData.setStatus(RentData.Statuses.CANCELED);
        this.em.merge(rentData);
    }
}
