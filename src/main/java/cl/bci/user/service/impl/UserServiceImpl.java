package cl.bci.user.service.impl;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;
import cl.bci.user.repository.UserRepository;
import cl.bci.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static cl.bci.user.mapper.UserMapper.*;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public InfoResponse createUser(UserModel user) {
        User userEntity = userRepository.save(mapUserRequestToUserEntity(user));
        return getInfoResponse(userEntity);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return mapUserEntityListToUserModelList(userList);
    }

    @Override
    public void deleteUser(String uuid) {
        userRepository.deleteByUuid(uuid);
    }

    @Override
    public UserModel getUserById(String uuid) {
        return mapUserEntityToUserModel(userRepository.findByUuid(uuid));
    }

}
