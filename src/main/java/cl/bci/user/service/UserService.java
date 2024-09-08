package cl.bci.user.service;

import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;

import java.util.List;

public interface UserService {

    InfoResponse createUser(UserModel user);

    List<UserModel> getAllUsers();

    void deleteUser(String uuid);

    UserModel getUserById(String uuid);

}
