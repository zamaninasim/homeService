package ir.maktab.model.entity.users;

import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @CreationTimestamp
    private Date registrationDate;
    private Long credit;
    @Enumerated(EnumType.STRING)
    private Role role;
}
