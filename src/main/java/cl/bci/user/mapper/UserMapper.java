package cl.bci.user.mapper;

import cl.bci.user.entity.User;
import cl.bci.user.model.request.UserModel;
import cl.bci.user.model.response.InfoResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static cl.bci.user.mapper.PhoneMapper.mapPhoneEntityToPhoneModel;
import static cl.bci.user.mapper.PhoneMapper.mapPhoneRequestToPhoneEntity;
import static cl.bci.user.util.TokenUtil.generateToken;
import static cl.bci.user.util.Utils.generateUUID;
import static cl.bci.user.util.Utils.getDate;

public class UserMapper {

    public static User mapUserRequestToUserEntity(UserModel user) {

        User userEntity = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .isActive(user.isActive()).uuid(generateUUID())
                .created(getDate())
                .modified("")
                .lastLogin(getDate())
                .token(generateToken(user.getEmail(), user.getName()))
                .build();

        userEntity.setPhones(mapPhoneRequestToPhoneEntity(user.getPhones(), userEntity.getUuid()));

        return userEntity;

    }

    public static InfoResponse getInfoResponse(User userEntity) {
        return InfoResponse.builder()
                .id(userEntity.getUuid())
                .created(userEntity.getCreated() == null ? "" : userEntity.getCreated())
                .modified(userEntity.getModified() == null ? "" : userEntity.getModified())
                .lastLogin(userEntity.getLastLogin() == null ? "" : userEntity.getLastLogin())
                .token(userEntity.getToken())
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
