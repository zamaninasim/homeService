package ir.maktab.service;

import ir.maktab.dao.UserDao;
import ir.maktab.model.entity.users.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class UserService {
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByEmailAddress(String emailAddress) {
        Optional<User> expert = userDao.findByEmailAddress(emailAddress);
        if (expert.isPresent()) {
            User foundedUser = expert.get();
            return foundedUser;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }
}