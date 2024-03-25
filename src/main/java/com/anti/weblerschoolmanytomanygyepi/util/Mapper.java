package com.anti.weblerschoolmanytomanygyepi.util;

import com.anti.weblerschoolmanytomanygyepi.entity.User;
import com.anti.weblerschoolmanytomanygyepi.model.UserModel;
import com.anti.weblerschoolmanytomanygyepi.model.UserRegistrationModel;

public class Mapper {

    public static UserModel mapUserEntityToUserModel(User entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setUsername(entity.getUsername());
        return model;
    }

    public Mapper() {

    }

    public static User  mapUserCreateModelToUserEntity(UserRegistrationModel model) {
        User entity = new User();
        entity.setEmail(model.getEmail());
        entity.setUsername(model.getUsername());
        entity.setPassword(model.getPassword());
        return entity;
    }
}
