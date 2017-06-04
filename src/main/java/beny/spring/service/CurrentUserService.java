package beny.spring.service;

import beny.spring.model.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
