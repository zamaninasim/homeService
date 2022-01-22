package ir.maktab.service;

import ir.maktab.dto.UserDto;

import java.util.List;

public interface UserService {

    public void save(UserDto userDto);

    public void update(UserDto userDto);

    public UserDto findByEmailAddress(String emailAddress);

    public List<UserDto> findUserByCondition(UserDto userDto);

    public void changePassword(UserDto userDto, String currentPassword, String newPassword);
}
