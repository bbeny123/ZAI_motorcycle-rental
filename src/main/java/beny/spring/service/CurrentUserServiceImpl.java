package beny.spring.service;


import beny.spring.model.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole().equals("ADMIN") || currentUser.getId().equals(userId));
    }

}
