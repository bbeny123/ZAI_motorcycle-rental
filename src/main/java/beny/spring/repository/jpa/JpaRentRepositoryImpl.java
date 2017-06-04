package beny.spring.repository.jpa;

import beny.spring.model.RentData;
import beny.spring.repository.RentRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

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
    public Collection<RentData> getAllRents() throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent");
        Collection<RentData> a = query.getResultList();
        System.out.println(a.isEmpty());
        return a;
    }

    @Override
    public Collection<RentData> getUserRents(Long id) throws DataAccessException {
        Query query = this.em.createQuery("SELECT rent FROM RentData rent WHERE rent.user.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveRent(RentData rentData) {
        System.out.println(rentData.getMotorcycle().getId());
        if (rentData.getId() == null) {
            this.em.persist(rentData);
        } else {
            this.em.merge(rentData);
        }
    }

    @Override
    public void deleteRent(Long id) {
        this.em.remove(findById(id));
    }
}
