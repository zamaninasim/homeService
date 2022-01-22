package ir.maktab.service;

import ir.maktab.data.dao.UserRepository;
import ir.maktab.data.model.entity.users.User;
import ir.maktab.dto.UserDto;
import ir.maktab.service.exception.EntityIsExistException;
import ir.maktab.service.exception.EntityNotExistException;
import ir.maktab.service.exception.InCorrectException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Optional<User> foundedUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (foundedUser.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void update(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @Override
    public UserDto findByEmailAddress(String emailAddress) {
        Optional<User> foundedUser = userRepository.findByEmailAddress(emailAddress);
        if (foundedUser.isPresent()) {
            User user = foundedUser.get();
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new EntityNotExistException("emailAddress not exist!");
        }
    }

    @Override
    public List<UserDto> findUserByCondition(UserDto userDto) {
        Specification<User> specification = UserRepository.selectByCondition(userDto);
        List<User> users = userRepository.findAll(specification);
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
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
