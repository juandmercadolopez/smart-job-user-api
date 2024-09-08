package cl.bci.user.service;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;

public interface UserService {

    User createOrUpdateUser(UserModel user);

}
