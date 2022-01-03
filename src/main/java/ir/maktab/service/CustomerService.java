package ir.maktab.service;

import ir.maktab.dao.CustomerDao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerService {
    private CustomerDao customerDao;
}
