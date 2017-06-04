package beny.spring.service;

import java.util.Collection;
import java.util.Optional;
import beny.spring.model.UserCreateForm;
import beny.spring.model.UserData;

/**
 * Created by Beny on 04.06.2017.
 */


public interface UserService {

    Optional<UserData> getUserById(long id);

    Optional<UserData> getUserByEmail(String email);

    Collection<UserData> getAllUsers();

    UserData create(UserCreateForm form);

    UserData save(UserData user);

}
