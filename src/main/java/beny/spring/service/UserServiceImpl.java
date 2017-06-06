package beny.spring.service;

import beny.spring.model.UserData;
import beny.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserData getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Optional<UserData> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserData save(UserData user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long aLong) {
        userRepository.delete(aLong);
    }
}