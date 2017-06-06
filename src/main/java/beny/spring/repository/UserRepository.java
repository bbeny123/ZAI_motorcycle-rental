package beny.spring.repository;

/**
 * Created by Beny on 04.06.2017.
 */

import beny.spring.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Long> {

    Optional<UserData> findOneByEmail(String email);

}
