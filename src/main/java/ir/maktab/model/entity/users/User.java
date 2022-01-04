package ir.maktab.model.entity.users;

import ir.maktab.model.enumeration.UserStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
