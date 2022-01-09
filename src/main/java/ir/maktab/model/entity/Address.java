package ir.maktab.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String city;
    private String state;
    private String streetAddress;
    private String houseNumber;
    private String zipCode;
}
