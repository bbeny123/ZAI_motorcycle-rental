package beny.spring.service;

import beny.spring.model.UserCreateForm;
import beny.spring.model.UserData;
import beny.spring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserData> getUserById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<UserData> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<UserData> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public UserData create(UserCreateForm form) {
        UserData user = new UserData();
        user.setEmail(form.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setAdmin(form.getRole());
        return userRepository.save(user);
    }

    public UserData save(UserData user) {
        return userRepository.save(user);
    }
}