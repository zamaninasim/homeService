package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.mapper.ExpertMapper;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SubServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);
    MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    SubService subService;

    @Test
    public void givenNewSubServiceWhitExistMainService_WhenSave_ThenReturnSubService() {
        MainService existMainService = mainServiceService.findByName("Cleaning and hygiene");
        subService = SubService.builder()
                .name("cleaning")
                .basePrice(100000L)
                .description("description")
                .mainService(existMainService)
                .build();
        SubService savedSubService = subServiceService.save(subService);
        assertEquals(subService, savedSubService);
    }

    @Test
    public void givenExistSubServiceWhitExistMainService_WhenSave_ThenThrowException() {
        MainService existMainService = mainServiceService.findByName("Cleaning and hygiene");
        subService = SubService.builder()
                .name("cleaning")
                .basePrice(100000L)
                .description("description")
                .mainService(existMainService)
                .build();
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> subServiceService.save(subService));
        assertTrue(thrown.getMessage().contains("this subService exist!"));
    }

    @Test
    public void givenNewSubServiceWhitNotExistMainService_WhenSave_ThenThrowException() {
        MainService notExistMainService = MainService.builder().name("aaa").build();
        subService = SubService.builder()
                .name("cleaning")
                .basePrice(100000L)
                .description("description")
                .mainService(notExistMainService)
                .build();
        EntityNotExistException thrown = assertThrows(EntityNotExistException.class, () -> subServiceService.save(subService));
        assertTrue(thrown.getMessage().contains("this mainService not exist!"));
    }

    @Test
    public void givenExistSubServiceName_WhenFindByName_ThenReturnSubService() {
        SubService subService = subServiceService.findByName("cleaning");
        assertNotNull(subService);
    }

    @Test
    public void givenNotExistSubServiceName_WhenFindByName_ThenThrowException() {
        EntityNotExistException thrown = assertThrows(EntityNotExistException.class, () -> subServiceService.findByName("aaa"));
        assertTrue(thrown.getMessage().contains("this subService not exist!"));
    }

    @Test
    public void givenExistSubService_WhenUpdate_ThenReturnSubService() {
        SubService existSubService = subServiceService.findByName("cleaning");
        existSubService.setDescription("new description");
        SubService updatedSubService = subServiceService.update(existSubService);
        assertEquals(existSubService, updatedSubService);
    }

    @Test
    public void givenSubServiceAndExpert_WhenAddExpertToSubService_ThenReturnSubService() {
        SubService subService = subServiceService.findByName("cleaning");
        Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
        SubService updatedSubService = subServiceService.addExpertToSubService(expert, subService);
        Set<Expert> experts = updatedSubService.getExperts();
        assertTrue(experts.contains(expert));
    }

    @Test
    public void givenSubServiceAndExpert_WhenRemoveExpertFromSubService_ThenReturnSubService() {
        SubService subService = subServiceService.findByName("cleaning");
        Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
        SubService updatedSubService = subServiceService.removeExpertFromSubService(expert, subService);
        Set<Expert> experts = updatedSubService.getExperts();
        assertFalse(experts.contains(expert));
    }

    @Test
    public void givenSubServiceName_WhenFindSubServiceExpertsBySubServiceName_ThenReturnExperts() {
        List<ExpertDto> expertDtos = subServiceService.findSubServiceExpertsBySubServiceName("cleaning");
        Expert expertOfThisSubService = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
        List<Expert> experts = new ArrayList<>();
        for (ExpertDto expertDto : expertDtos) {
            Expert expert = expertService.findByEmailAddress(expertDto.getEmailAddress());
            experts.add(expert);
        }
        List<Expert> expectedList =new ArrayList<>();
        expectedList.add(expertOfThisSubService);
        assertEquals(expectedList,experts);
    }


}
