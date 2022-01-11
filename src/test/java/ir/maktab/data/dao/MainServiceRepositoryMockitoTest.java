package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.service.MainServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceRepositoryMockitoTest {
    @Mock
    private MainServiceRepository mainServiceRepository;
    @InjectMocks
    private MainServiceService mainServiceService;
    @Test
    public void whenSaveMainService_shouldReturnMainService() {
        MainService mainService = MainService.builder().name("Home Appliances").build();
        when(mainServiceRepository.save(ArgumentMatchers.any(MainService.class))).thenReturn(mainService);
        MainService created = mainServiceService.save(mainService);
        assertThat(created.getName()).isSameAs(mainService.getName());
        verify(mainServiceRepository).save(mainService);
    }
}
