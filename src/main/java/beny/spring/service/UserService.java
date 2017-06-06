package beny.spring.service;

import beny.spring.model.UserData;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Beny on 04.06.2017.
 */


public interface UserService {

    Optional<UserData> getUserById(long id);

    Optional<UserData> getUserByEmail(String email);

    Collection<UserData> getAllUsers();

    UserData save(UserData user);

}
