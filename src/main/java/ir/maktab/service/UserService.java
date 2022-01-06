package ir.maktab.service;

import ir.maktab.dao.UserDao;
import ir.maktab.model.entity.users.User;
import ir.maktab.model.enumeration.Role;
import ir.maktab.validation.exception.IsExistException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void save(User user) {
        Optional<User> foundedUser = userDao.findByEmailAddress(user.getEmailAddress());
        if (foundedUser.isPresent()) {
            throw new IsExistException("this emailAddress exist!");
        } else {
            userDao.save(user);
            System.out.println("user whit '" + user.getEmailAddress() + "' emailAddress saved.");
        }
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User findByEmailAddress(String emailAddress) {
        Optional<User> expert = userDao.findByEmailAddress(emailAddress);
        if (expert.isPresent()) {
            return expert.get();
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }

    public List<User> findUserByCondition(String firstname, String lastname, String email, Role role) {
        return userDao.findUserByCondition(firstname, lastname, email, role);
    }

    public void changePassword(User user,String currentPassword, String newPassword) {
        String password = user.getPassword();
        if (password.equals(currentPassword)) {
            user.setPassword(newPassword);
            update(user);
            System.out.println("your password change successfully.");
        }
    }
}
