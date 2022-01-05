package ir.maktab.service;

import ir.maktab.dao.ExpertDao;
import ir.maktab.dao.UserDao;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.entity.users.User;
import ir.maktab.validation.exception.ExistException;
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
}
