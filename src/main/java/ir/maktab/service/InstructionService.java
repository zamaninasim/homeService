package ir.maktab.service;

import ir.maktab.dao.InstructionDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class InstructionService {
    private final InstructionDao orderDao;
}
