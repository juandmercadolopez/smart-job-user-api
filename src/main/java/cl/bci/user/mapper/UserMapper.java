package cl.bci.user.mapper;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static cl.bci.user.mapper.PhoneMapper.mapPhoneEntityToPhoneModel;
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

    public static InfoResponse getInfoResponse(User userEntity) {
        return InfoResponse.builder()
                .id(userEntity.getUuid())
                .created(userEntity.getCreated() == null ? "" : userEntity.getCreated())
                .modified(userEntity.getModified() == null ? "" : userEntity.getModified())
                .lastLogin(userEntity.getLastLogin() == null ? "" : userEntity.getLastLogin())
                .token("token")
                .isActive(userEntity.getIsActive()).build();
    }

    public static List<UserModel> mapUserEntityListToUserModelList(List<User> userList) {
        List<UserModel> userModelList = new ArrayList<>();
        userList.forEach(user -> {
            userModelList.add(UserModel.builder()
                    .uuid(user.getUuid())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .isActive(user.getIsActive())
                    .phones(mapPhoneEntityToPhoneModel(user.getPhones()))
                    .build());
        });
        return userModelList;
    }

    public static UserModel mapUserEntityToUserModel(User userEntity) {
        return UserModel.builder()
                .uuid(userEntity.getUuid())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .isActive(userEntity.getIsActive())
                .phones(mapPhoneEntityToPhoneModel(userEntity.getPhones()))
                .build();
    }


}
