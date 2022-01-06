package ir.maktab.view;

import ir.maktab.config.Config;
import ir.maktab.model.ImageReader;
import ir.maktab.model.builder.CommentBuilder;
import ir.maktab.model.entity.Comment;
import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.Offer;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.InstructionStatus;
import ir.maktab.model.enumeration.OfferStatus;
import ir.maktab.service.*;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.validation.Validation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;

public class HardCoreMain {
    final static Scanner scanner = new Scanner(System.in);
    final static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    final static ManagerService managerService = context.getBean(ManagerService.class);
    final static MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    final static SubServiceService subServiceService = context.getBean(SubServiceService.class);
    final static CustomerService customerService = context.getBean(CustomerService.class);
    final static ExpertService expertService = context.getBean(ExpertService.class);
    final static UserService userService = context.getBean(UserService.class);
    final static InstructionService instructionService = context.getBean(InstructionService.class);
    final static OfferService offerService = context.getBean(OfferService.class);
    final static CommentService commentService = context.getBean(CommentService.class);
    final static ImageReader myImage = new ImageReader();
    final static Mapper mapper = new Mapper();
    final static Validation validation = new Validation();

    public static void main(String[] args) throws ParseException {

        //اضافه کردن سرویس اصلی
       /*try {
           MainService mainService = MainServiceBuilder.aMainService().withName("Home Appliances").build();
           mainServiceService.save(mainService);
        } catch (RuntimeException e) {
           System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainServiceBuilder.aMainService().withName("Cleaning and hygiene").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainServiceBuilder.aMainService().withName("Building decoration").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainServiceBuilder.aMainService().withName("Building Facilities").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            MainService mainService = MainServiceBuilder.aMainService().withName("vehicles").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        // خدمت تکراری
        /*try {
            MainService mainService = MainServiceBuilder.aMainService().withName("vehicles").build();
            mainServiceService.save(mainService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن سرویس فرعی
        /*try {
            MainService mainService = mainServiceService.findByName("Cleaning and hygiene");
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
            MainService mainService = mainServiceService.findByName("Home Appliances");
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
        }*/
        //زیر خدمت تکراری
        /*try {
            MainService mainService = mainServiceService.findByName("Cleaning and hygiene");
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
            User customer = CustomerBuilder
                    .aCustomer()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withRole(Role.CUSTOMER)
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
            User customer = CustomerBuilder
                    .aCustomer()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withRole(Role.CUSTOMER)
                    .build();
            userService.save(customer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/
        //اضافه کردن متخصص
        /*try {
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

            User expert = ExpertBuilder.anExpert()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withScore(5.0)
                    .withPhoto(image)
                    .withRole(Role.EXPERT)
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

            User expert = ExpertBuilder.anExpert()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(email)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withScore(5.0)
                    .withPhoto(image)
                    .withRole(Role.EXPERT)
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
            Instruction instruction = InstructionBuilder
                    .anInstruction()
                    .withProposedPrice(1000000L)
                    .withJobDescription("description")
                    .withDateOfWorkPerformed(date)
                    .withAddress("address")
                    .withCustomer(customer)
                    .withOrderStatus(InstructionStatus.WAITING_FOR_EXPERT_SUGGESTIONS)
                    .withSubService(subService)
                    .build();
            instructionService.save(instruction);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }*/

        // ایجاد پیشنهاد برای یک سفارش
        /*try {
            Instruction instruction = instructionService.get(1);
            Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
            Offer offer = OfferBuilder
                    .anOffer()
                    .withExpert(expert)
                    .withInstruction(instruction)
                    .withProposedPrice(500000L)
                    .withDurationOfWork(5)
                    .withStartTime(startDate)
                    .withOfferStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToInstruction(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            Instruction instruction = instructionService.get(1);
            Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 00:30");
            Offer offer = OfferBuilder
                    .anOffer()
                    .withExpert(expert)
                    .withInstruction(instruction)
                    .withProposedPrice(500000L)
                    .withDurationOfWork(5)
                    .withStartTime(startDate)
                    .withOfferStatus(OfferStatus.UNCHECKED)
                    .build();
            offerService.addOfferToInstruction(offer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }*/


        //نظر دادن راجع به سفارش
        try {
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
        }
    }
}
