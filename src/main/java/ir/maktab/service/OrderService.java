package ir.maktab.service;

import ir.maktab.dao.OrderDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
}
