package beny.spring.repository.jpa;

import beny.spring.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Beny on 04.06.2017.
 */

@Repository
public abstract class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;
}
