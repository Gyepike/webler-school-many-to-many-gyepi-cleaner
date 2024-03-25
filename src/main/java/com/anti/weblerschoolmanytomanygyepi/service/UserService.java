package com.anti.weblerschoolmanytomanygyepi.service;

import com.anti.weblerschoolmanytomanygyepi.exception.UserAlreadyExistsException;
import com.anti.weblerschoolmanytomanygyepi.entity.User;
import com.anti.weblerschoolmanytomanygyepi.model.UserModel;
import com.anti.weblerschoolmanytomanygyepi.model.UserRegistrationModel;
import com.anti.weblerschoolmanytomanygyepi.persistence.UserRepository;
import com.anti.weblerschoolmanytomanygyepi.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<UserModel> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(Mapper::mapUserEntityToUserModel)
                .collect(Collectors.toList());
    }

    public  UserModel createUser(UserRegistrationModel userRegistrationModel) {
        UserModel foundUser = findUserByEmail(userRegistrationModel.getEmail());
        if (foundUser != null) {
            String message = String.format("User already exists with email: %s", userRegistrationModel.getEmail());
            log.info(message);
            throw new UserAlreadyExistsException(message);
        } else {
            return Mapper.mapUserEntityToUserModel(userRepository.save(Mapper.mapUserCreateModelToUserEntity(userRegistrationModel)));
        }
    }

    private UserModel findUserByEmail(String email) {
        // van vagy nincs?
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        // ha nincs, akkor kezeljük a "hibát" -> vagy null-t adunk vissza! (ez utóbbi jobb, mert szükség esetén kezeljük a null-t később, a helyén
        // ha van akkor megyünk tovább a logikával
        return optionalUser.map(Mapper::mapUserEntityToUserModel).orElse(null);
    }

    public UserModel findUserById(Long id) {
        return Mapper.mapUserEntityToUserModel(userRepository.findUserById(id)
                .orElseThrow(() -> {
                    String message = String.format("User not exists with id: %s", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                }));
    }
}
