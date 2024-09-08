package cl.bci.user.mapper;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;

import java.util.ArrayList;
import java.util.Objects;

import static cl.bci.user.mapper.PhoneMapper.mapPhoneRequestToPhoneEntity;
import static cl.bci.user.util.Utils.generateUUID;
import static cl.bci.user.util.Utils.getDate;

public class UserMapper {

    public static User mapUserRequestToUserEntity(UserModel user) {

        User userEntity = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .isActive(user.isActive())
                .build();

        if (Objects.isNull(user.getUuid())) {
            userEntity.setUuid(generateUUID());
            userEntity.setCreated(getDate());
            userEntity.setLastLogin(getDate());
        } else {
            userEntity.setModified(getDate());
            userEntity.setUuid(user.getUuid());
        }

        userEntity.setPhones(mapPhoneRequestToPhoneEntity(user.getPhones(), userEntity.getUuid()));


        return userEntity;

    }

    public static InfoResponse getInfoResponse(User userEntity){
        return InfoResponse.builder()
                .id(userEntity.getUuid())
                .created(userEntity.getCreated())
                .modified("modified")
                .lastLogin(userEntity.getLastLogin())
                .token("token")
                .isActive(userEntity.getIsActive()).build();
    }


}
