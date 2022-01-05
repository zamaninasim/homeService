package ir.maktab.service;

import ir.maktab.dao.SuggestionDao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final SuggestionDao suggestionDao;
}
