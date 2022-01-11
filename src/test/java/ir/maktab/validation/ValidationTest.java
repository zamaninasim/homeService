package ir.maktab.validation;

import ir.maktab.config.Config;
import ir.maktab.exception.InvalidEmailException;
import ir.maktab.exception.InvalidNameException;
import ir.maktab.exception.InvalidNumberException;
import ir.maktab.exception.InvalidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class ValidationTest {
    Validation validation;

    @BeforeEach
    void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        validation = context.getBean(Validation.class);
    }

    @ParameterizedTest
    @CsvSource({"zamaninasim213@gmail.com", "aliJafari@yahoo.com", "email@example.com"})
    void givenCorrectEmails_WhenValidateEmail_ThenReturnTrueResponse(String email) {
        boolean result = validation.validateEmail(email);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"nasimZamani.email", "@gmail.com", "1236"})
    void givenNotCorrectEmails_WhenValidateEmail_ThenThrowException(String email) {
        InvalidEmailException thrown =
                assertThrows(InvalidEmailException.class, () -> validation.validateEmail(email));
        assertTrue(thrown.getMessage().contains("invalid Email!"));
    }

    @ParameterizedTest
    @CsvSource({"nasim", "ali", "zamani", "mohmmadAli"})
    void givenCorrectNames_WhenValidateName_ThenReturnTrueResponse(String name) {
        boolean result = validation.validateName(name);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"123", "na", "nasimmmmmmmmmmmmmmmm"})
    void givenNotCorrectNames_WhenValidateName_ThenThrowException(String name) {
        InvalidNameException thrown =
                assertThrows(InvalidNameException.class, () -> validation.validateName(name));
        assertTrue(thrown.getMessage().contains("invalid name!"));
    }
    @ParameterizedTest
    @CsvSource({"1", "2365", "0", "1961529"})
    void givenCorrectNumbers_WhenValidateNumber_ThenReturnTrueResponse(String number) {
        boolean result = validation.validateNumber(number);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"0011","na","-1"})
    void givenNotCorrectNumbers_WhenValidateNumber_ThenThrowException(String number) {
        InvalidNumberException thrown =
                assertThrows(InvalidNumberException.class, () -> validation.validateNumber(number));
        assertTrue(thrown.getMessage().contains("invalid number!"));
    }

    @ParameterizedTest
    @CsvSource({"Nasim1374", "AAll1235", "saraA@546", "123-NASIMz", "zamani.N1"})
    void givenCorrectPasswords_WhenValidatePassword_ThenReturnTrueResponse(String password) {
        boolean result = validation.validatePassword(password);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"123", "1233333555", "nasimzamani", "nasim"})
    void givenNotCorrectPasswords_WhenValidatePassword_ThenThrowException(String password) {
        InvalidPasswordException thrown =
                assertThrows(InvalidPasswordException.class, () -> validation.validatePassword(password));
        assertTrue(thrown.getMessage().contains("invalid password!"));
    }
}
