package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUserByCondition(String firstname, String lastname, String email, Role role);
}
