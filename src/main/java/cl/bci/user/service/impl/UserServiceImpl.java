package cl.bci.user.service.impl;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;
import cl.bci.user.repository.UserRepository;
import cl.bci.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static cl.bci.user.mapper.UserMapper.getInfoResponse;
import static cl.bci.user.mapper.UserMapper.mapUserRequestToUserEntity;

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

}
