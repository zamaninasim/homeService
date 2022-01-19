package ir.maktab.service;

import ir.maktab.data.dao.UserRepository;
import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.dto.UserDto;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.exception.InCorrectException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Optional<User> foundedUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (foundedUser.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            userRepository.save(user);
        }
    }

    public void update(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    public UserDto findByEmailAddress(String emailAddress) {
        Optional<User> foundedUser = userRepository.findByEmailAddress(emailAddress);
        if (foundedUser.isPresent()) {
            User user = foundedUser.get();
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new EntityNotExistException("emailAddress not exist!");
        }
    }

    public List<UserDto> findUserByCondition(String firstname, String lastname, String email, Role role) {
        Specification<User> specification = UserRepository.selectByCondition(firstname, lastname, email, role);
        List<User> users = userRepository.findAll(specification);
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    public void changePassword(UserDto userDto, String currentPassword, String newPassword) {
        User user = modelMapper.map(userDto, User.class);
        String password = user.getPassword();
        if (password.equals(currentPassword)) {
            user.setPassword(newPassword);
            System.out.println("your password change successfully.");
            UserDto newUserDto = modelMapper.map(user, UserDto.class);
            update(newUserDto);
        } else {
            throw new InCorrectException("password is wrong!");
        }
    }
}
