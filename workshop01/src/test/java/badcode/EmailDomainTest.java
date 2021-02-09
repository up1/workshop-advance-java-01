package badcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailDomainTest {

    @Test
    public void invalid_domain_email_throw_DomainEmailInvalidException() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> {
            final String invalidEmail = "somkiat@";
            registerBusiness.getEmailDomain(invalidEmail);
        });
    }
}