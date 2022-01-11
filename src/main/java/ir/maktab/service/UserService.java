package ir.maktab.service;

import ir.maktab.data.dao.UserRepository;
import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.mapper.UserMapper;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.exception.InCorrectException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User save(User user) {
        Optional<User> foundedUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (foundedUser.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            return userRepository.save(user);
        }
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User findByEmailAddress(String emailAddress) {
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotExistException("emailAddress not exist!");
        }
    }

    public List<UserDto> findUserByCondition(String firstname, String lastname, String email, Role role) {
        List<User> users = userRepository.findUserByCondition(firstname, lastname, email, role);
        List<UserDto> userDtos = users.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
        return userDtos;
    }

    public User changePassword(User user, String currentPassword, String newPassword) {
        String password = user.getPassword();
        if (password.equals(currentPassword)) {
            user.setPassword(newPassword);
            System.out.println("your password change successfully.");
            return update(user);
        }else {
            throw new InCorrectException("password is wrong!");
        }
    }
}
