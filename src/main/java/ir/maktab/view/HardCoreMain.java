package ir.maktab.view;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.Address;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.OfferStatus;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.service.reader.ImageReader;
import ir.maktab.service.*;
import ir.maktab.dto.mapper.OfferMapper;
import ir.maktab.validation.Validation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HardCoreMain {
    final static Scanner scanner = new Scanner(System.in);
    final static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    final static ManagerService managerService = context.getBean(ManagerService.class);
    final static MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    final static SubServiceService subServiceService = context.getBean(SubServiceService.class);
    final static CustomerService customerService = context.getBean(CustomerService.class);
    final static ExpertService expertService = context.getBean(ExpertService.class);
    final static UserService userService = context.getBean(UserService.class);
    final static OrderService orderService = context.getBean(OrderService.class);
    final static OfferService offerService = context.getBean(OfferService.class);
    final static CommentService commentService = context.getBean(CommentService.class);
    final static ImageReader myImage = new ImageReader();
    final static Validation validation = new Validation();

    public static void main(String[] args) throws ParseException {

        //اضافه کردن سرویس اصلی
       /*try {
           MainService mainService = MainService.builder().name("Home Appliances").build();
           mainServiceService.save(mainService);
        } catch (RuntimeException e) {
           System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainService.builder().name("Cleaning and hygiene").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainService.builder().name("Building decoration").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainService.builder().name("Building Facilities").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainService.builder().name("vehicles").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        // خدمت تکراری
        /*try {
            MainService mainService = MainService.builder().name("vehicles").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن سرویس فرعی
        try {
            MainService mainService = mainServiceService.findByName("Cleaning and hygiene");
            SubService subService = SubService.builder()
                    .name("cleaning")
                    .basePrice(100000L)
                    .description("description")
                    .mainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
       /* try {
            MainService mainService = mainServiceService.findByName("Home Appliances");
            SubService subService =SubService.builder()
                    .name("Kitchen appliances")
                    .basePrice(500000L)
                    .description("description")
                    .mainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //زیر خدمت تکراری
        /*try {
            MainService mainService = mainServiceService.findByName("Cleaning and hygiene");
            SubService subService =SubService.builder()
                    .name("cleaning")
                    .basePrice(100000L)
                    .description("description")
                    .mainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن زیر خدمتی که خدمت اصلی تعریف نشده
        /*try {
            MainService mainService = mainServiceService.findByName("Furniture and bearing");
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
            String firstname = "neda";
            validation.validateName(firstname);
            String lastname = "akbari";
            validation.validateName(lastname);
            String email = "nedaakbari213@gmail.com";
            validation.validateEmail(email);
            String password = "nedA1377";
            validation.validatePassword(password);
            User customer = Customer.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .role(Role.CUSTOMER)
                    .userStatus(UserStatus.NEW)
                    .credit(0L)
                    .build();
            userService.save(customer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            String firstname = "maryam";
            validation.validateName(firstname);
            String lastname = "goli";
            validation.validateName(lastname);
            String email = "maryamgoli213@gmail.com";
            validation.validateEmail(email);
            String password = "Maryam1245";
            validation.validatePassword(password);
            User customer = Customer.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .role(Role.CUSTOMER)
                    .userStatus(UserStatus.NEW)
                    .credit(0L)
                    .build();
            userService.save(customer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن متخصص
        /*try {
            String firstname = "aliakbar";
            validation.validateName(firstname);
            String lastname = "godarzi";
            validation.validateName(lastname);
            String email = "aliakbargodarzi@gmail.com";
            validation.validateEmail(email);
            String password = "akBar1234";
            validation.validatePassword(password);
            String imagePath = "\\nasim.jpg";
            byte[] image = myImage.fileToBytes(imagePath);

            User expert = Expert.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .credit(0L)
                    .userStatus(UserStatus.NEW)
                    .score(5.0)
                    .photo(image)
                    .role(Role.EXPERT)
                    .build();
            userService.save(expert);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            String firstname = "faeze";
            validation.validateName(firstname);
            String lastname = "shariati";
            validation.validateName(lastname);
            String email = "faezeshariati@gmail.com";
            validation.validateEmail(email);
            String password = "Faeze1234";
            validation.validatePassword(password);
            String imagePath = "\\nasim.jpg";
            byte[] image = myImage.fileToBytes(imagePath);

            User expert = Expert.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .credit(0L)
                    .userStatus(UserStatus.NEW)
                    .score(5.0)
                    .photo(image)
                    .role(Role.EXPERT)
                    .build();
            userService.save(expert);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            String firstname = "ali";
            validation.validateName(firstname);
            String lastname = "jafari";
            validation.validateName(lastname);
            String email = "alijafari@gmail.com";
            validation.validateEmail(email);
            String password = "Aliiii1234";
            validation.validatePassword(password);
            String imagePath = "\\nasim.jpg";
            byte[] image = myImage.fileToBytes(imagePath);

            User expert = Expert.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .credit(0L)
                    .userStatus(UserStatus.NEW)
                    .score(5.0)
                    .photo(image)
                    .role(Role.EXPERT)
                    .build();
            userService.save(expert);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            String firstname = "nasim";
            validation.validateName(firstname);
            String lastname = "zamani";
            validation.validateName(lastname);
            String email = "zamaninasim213@gmail.com";
            validation.validateEmail(email);
            String password = "Nasim1234";
            validation.validatePassword(password);
            String imagePath = "\\nasim.jpg";
            byte[] image = myImage.fileToBytes(imagePath);

            User expert = Expert.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .emailAddress(email)
                    .password(password)
                    .credit(0L)
                    .userStatus(UserStatus.NEW)
                    .score(5.0)
                    .photo(image)
                    .role(Role.EXPERT)
                    .build();
            userService.save(expert);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }*/
        //تغییر رمز کاربر
        /*try {
            User user = userService.findByEmailAddress("zamaninasim213@gmail.com");
            String currentPassword = "Nasim1234";
            String newPassword = "nasimZ642840";
            validation.validatePassword(newPassword);
            userService.changePassword(user,currentPassword,newPassword);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن متخصص به زیر خدمت
        /*try {
            SubService subService = subServiceService.findByName("Kitchen appliances");
            Expert expert = expertService.findByEmailAddress("faezeshariati@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("cleaning");
            Expert expert = expertService.findByEmailAddress("faezeshariati@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("Kitchen appliances");
            Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("cleaning");
            Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("Kitchen appliances");
            Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("cleaning");
            Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("Kitchen appliances");
            Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            SubService subService = subServiceService.findByName("cleaning");
            Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            subServiceService.addExpertToSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //حذف متخصص از زیر خدمت
        /*try {
            SubService subService = subServiceService.findByName("cleaning");
            Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            subServiceService.removeExpertFromSubService(expert, subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //جستجو یوزر
        /*List<UserDto> userDtos = userService.findUserByCondition("nasim", "zamani", "zamaninasim213@gmail.com", Role.EXPERT);
        System.out.println(userDtos);*/
        //جستجو حوزه تخصصی متخصصان
        /*List<SubServiceDto> serviceDtos = expertService.findServicesByEmail("zamaninasim213@gmail.com");
        System.out.println(serviceDtos);*/
        //جستجو مختصصان یک حوزه
        /*List<ExpertDto> expertDtos = subServiceService.findExpertsByName("Kitchen appliances");
        System.out.println(expertDtos);*/
        //ایجاد سفارش
        /*try {
            Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 12:30");
            SubService subService = subServiceService.findByName("cleaning");
            Address address = Address
                    .builder()
                    .city("tehran")
                    .state("resalat")
                    .streetAddress("ghazvini.st")
                    .houseNumber("12")
                    .zipCode(86165841L)
                    .build();

            Order order = Order.builder()
                    .proposedPrice(1000000L)
                    .jobDescription("description")
                    .dateOfWorkPerformed(date)
                    .address(address)
                    .customer(customer)
                    .orderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTIONS)
                    .subService(subService)
                    .build();
            orderService.save(order);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1401-02-20 08:00");
            SubService subService = subServiceService.findByName("cleaning");
            Address address = Address
                    .builder()
                    .city("tehran")
                    .state("resalat")
                    .streetAddress("ghazvini.st")
                    .houseNumber("12")
                    .zipCode(86165841L)
                    .build();

            Order order = Order.builder()
                    .proposedPrice(1000000L)
                    .jobDescription("description")
                    .dateOfWorkPerformed(date)
                    .address(address)
                    .customer(customer)
                    .orderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTIONS)
                    .subService(subService)
                    .build();
            orderService.save(order);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        try {
            Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-12-20 09:00");
            SubService subService = subServiceService.findByName("cleaning");
            Address address = Address
                    .builder()
                    .city("tehran")
                    .state("resalat")
                    .streetAddress("ghazvini.st")
                    .houseNumber("12")
                    .zipCode(86165841L)
                    .build();

            Order order = Order.builder()
                    .proposedPrice(1000000L)
                    .jobDescription("description")
                    .dateOfWorkPerformed(date)
                    .address(address)
                    .customer(customer)
                    .orderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTIONS)
                    .subService(subService)
                    .build();
            orderService.save(order);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }*/
        // ایجاد پیشنهاد برای یک سفارش
        /*try {
            Order order = orderService.findByTrackingNumber(1L);
            Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
            Offer offer = Offer.builder()
                    .expert(expert)
                    .order(order)
                    .proposedPrice(500000L)
                    .durationOfWork(5)
                    .startTime(startDate)
                    .offerStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToOrder(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            Order order = orderService.findByTrackingNumber(1L);
            Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
            Offer offer = Offer.builder()
                    .expert(expert)
                    .order(order)
                    .proposedPrice(500000L)
                    .durationOfWork(5)
                    .startTime(startDate)
                    .offerStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToOrder(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            Order order = orderService.findByTrackingNumber(1L);
            Expert expert = expertService.findByEmailAddress("faezeshariati@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
            Offer offer = Offer.builder()
                    .expert(expert)
                    .order(order)
                    .proposedPrice(500000L)
                    .durationOfWork(5)
                    .startTime(startDate)
                    .offerStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToOrder(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            Order order = orderService.findByTrackingNumber(1L);
            Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
            Offer offer = Offer.builder()
                    .expert(expert)
                    .order(order)
                    .proposedPrice(500000L)
                    .durationOfWork(5)
                    .startTime(startDate)
                    .offerStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToOrder(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //نظر دادن راجع به سفارش
        /*try {
            Instruction instruction = instructionService.get(1);
            Offer acceptedOffer = instructionService.findAcceptedOfferOfInstruction(instruction);
            Expert expert = acceptedOffer.getExpert();
            Double instructionsScore = 4D;
            expertService.updateScore(expert, instructionsScore);
            Comment comment = CommentBuilder.aComment()
                    .withScore(instructionsScore)
                    .withOpinion("opinion")
                    .withInstruction(instruction)
                    .build();
            commentService.save(comment);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
