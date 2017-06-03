package beny.spring.repository.jpa;

import beny.spring.repository.RentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Beny on 04.06.2017.
 */

@Repository
public class JpaRentRepositoryImpl implements RentRepository {

    @PersistenceContext
    private EntityManager em;
}
