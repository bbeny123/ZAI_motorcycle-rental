package beny.spring.service;

import beny.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Beny on 04.06.2017.
 */

@Service
public class ServiceUserImpl implements ServiceUser {

    private UserRepository userRepository;

    @Autowired
    public ServiceUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
