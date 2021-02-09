package badcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterFeeTest {

    @Test
    public void exp_1_year_should_fee_500() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(500, registerBusiness.getFee(1));
        assertEquals(250, registerBusiness.getFee(3));
        assertEquals(100, registerBusiness.getFee(5));
        assertEquals(50, registerBusiness.getFee(9));
        assertEquals(0, registerBusiness.getFee(10));
    }

    // https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-CsvSource
    @ParameterizedTest
    @CsvSource({
            "1, 500",
            "2, 250",
            "3, 250",
            "4, 100",
            "5, 100",
            "5, 100",
            "9, 50",
            "10, 0"
    })
    public void calculate_fee_from_exp(int expYear, int fee) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(fee, registerBusiness.getFee(expYear));
    }
}