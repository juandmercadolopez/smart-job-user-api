package cl.bci.user.service.impl;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;
import cl.bci.user.repository.UserRepository;
import cl.bci.user.service.UserService;
import cl.bci.user.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static cl.bci.user.mapper.PhoneMapper.mapPhoneRequestToPhoneEntity;
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
    public InfoResponse updateUser(UserModel user) {
        User userEntity = userRepository.findByUuid(user.getUuid());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userEntity.setPhones(mapPhoneRequestToPhoneEntity(user.getPhones(), user.getUuid()));
        userEntity.setIsActive(user.isActive());
        userEntity.setModified(Utils.getDate());
        userRepository.save(userEntity);
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
