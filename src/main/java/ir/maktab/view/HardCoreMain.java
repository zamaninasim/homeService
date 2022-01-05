package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.ImageReader;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.service.*;
import ir.maktab.validation.Validation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class HardCoreMain {
    final static Scanner scanner = new Scanner(System.in);
    final static ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
    final static ManagerService managerService = context.getBean(ManagerService.class);
    final static MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    final static SubServiceService subServiceService = context.getBean(SubServiceService.class);
    final static CustomerService customerService = context.getBean(CustomerService.class);
    final static ExpertService expertService = context.getBean(ExpertService.class);
    final static UserService userService = context.getBean(UserService.class);
    final static ImageReader myImage = new ImageReader();
    final static Validation validation = new Validation();

    public static void main(String[] args) {
        //اضافه کردن سرویس اصلی
/*        try {
            mainServiceService.findMainService("Home Appliances");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("Home Appliances").build();
            mainServiceService.save(mainService);
        }

        try {
            mainServiceService.findMainService("Cleaning and hygiene");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("Cleaning and hygiene").build();
            mainServiceService.save(mainService);
        }

        try {
            mainServiceService.findMainService("Building decoration");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("Building decoration").build();
            mainServiceService.save(mainService);
        }

        try {
            mainServiceService.findMainService("Building Facilities");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("Building Facilities").build();
            mainServiceService.save(mainService);
        }

        try {
            mainServiceService.findMainService("vehicles");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("vehicles").build();
            mainServiceService.save(mainService);
        }
        // خدمت تکراری
        try {
            mainServiceService.findMainService("vehicles");
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName("vehicles").build();
            mainServiceService.save(mainService);
        }
        //اضافه کردن سرویس فرعی
        try {
            MainService mainService = mainServiceService.findMainService("Cleaning and hygiene");
            subServiceService.isSubServiceExist("cleaning");
            SubService subService = SubServiceBuilder
                    .aSubService()
                    .withName("cleaning")
                    .withBasePrice(100000L)
                    .withDescription("description")
                    .withMainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = mainServiceService.findMainService("Home Appliances");
            subServiceService.isSubServiceExist("Kitchen appliances");
            SubService subService = SubServiceBuilder
                    .aSubService()
                    .withName("Kitchen appliances")
                    .withBasePrice(500000L)
                    .withDescription("description")
                    .withMainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        //زیر خدمت تکراری
        try {
            MainService mainService = mainServiceService.findMainService("Cleaning and hygiene");
            subServiceService.isSubServiceExist("cleaning");
            SubService subService = SubServiceBuilder
                    .aSubService()
                    .withName("cleaning")
                    .withBasePrice(100000L)
                    .withDescription("description")
                    .withMainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن زیر خدمتی که خدمت اصلی تعریف نشده
        /*try {
            MainService mainService = mainServiceService.findMainService("Furniture and bearing");
            subServiceService.isSubServiceExist("bearing");
            SubService subService = SubServiceBuilder
                    .aSubService()
                    .withName("bearing")
                    .withBasePrice(1000000L)
                    .withDescription("description")
                    .withMainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن مشتری
        /*try {
            String firstname = "nasim";
            boolean validateFirstname = validation.validateName(firstname);
            String lastname = "zamani";
            boolean validateLastname = validation.validateName(lastname);
            String email = "zamaninasim213@gmail.com";
            boolean validateEmail = validation.validateEmail(email);
            String password = "Nasim1374";
            boolean validatePassword = validation.validatePassword(password);
            customerService.isExist(email);
            User customer = CustomerBuilder
                    .aCustomer()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .build();
            userService.save(customer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن متخصص
        /*try {
            String firstname = "ali";
            boolean validateFirstname = validation.validateName(firstname);
            String lastname = "jafari";
            boolean validateLastname = validation.validateName(lastname);
            String email = "alijafari@gmail.com";
            boolean validateEmail = validation.validateEmail(email);
            String password = "Aliiii1234";
            boolean validatePassword = validation.validatePassword(password);
            expertService.isExist(email);
            String imagePath = "\\nasim.jpg";
            byte[] image = myImage.fileToBytes(imagePath);
            User expert = ExpertBuilder.anExpert()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withScore(5.0)
                    .withPhoto(image)
                    .build();
            userService.save(expert);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }*/
        //تغییر رمز کاربر
        /*try {
            User user = userService.findByEmailAddress("zamaninasim213@gmail.com");
            String password = user.getPassword();
            String inputPassword = "Nasim1374";
            String newPassword = "nasimZ642840";
            boolean validatePassword = validation.validatePassword(password);
            if (password.equals(inputPassword)){
                user.setPassword(newPassword);
            }
            userService.update(user);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن متخصص به زیر خدمت
        try {
            //SubService subService = subServiceService.findByName("Kitchen appliances");
            SubService subService = subServiceService.findByNameCriteria("Kitchen appliances");
            //Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            System.out.println(subService);
            //subService.getExperts().add(expert);
           // subServiceService.update(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
