package com.realaicy.tna.modules.core.beanvalidator;

import com.realaicy.tna.modules.core.test.data.TCListener;
import com.realaicy.tna.modules.core.test.data.TCWatcher;
import com.realaicy.tna.modules.core.test.spring.SpringBaseNGTest;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
@Listeners(TCListener.class)
public class BeanValidatorsTest extends SpringBaseNGTest {

    @Autowired
    private Validator validator;

    @BeforeClass
    public static void beforeClass() {
        // To avoid the non-English environment test failure on message asserts.
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    public void validate() {

        Customer customer = new Customer();
        customer.setEmail("aaa");

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertThat(violations).hasSize(2);

        // extract message as list
        List<String> result = BeanValidators.extractMessage(violations);
        assertThat(result).containsOnly("not a well-formed email address", "may not be empty");

        // extract propertyPath and message as map;
        Map mapResult = BeanValidators.extractPropertyAndMessage(violations);
        assertThat(mapResult).containsOnly(entry("email", "not a well-formed email address"),
                entry("name", "may not be empty"));

        // extract propertyPath and message as map;
        result = BeanValidators.extractPropertyAndMessageAsList(violations);
        assertThat(result).containsOnly("email not a well-formed email address", "name may not be empty");
    }

    @Test
    public void validateWithException() {
        Customer customer = new Customer();
        customer.setEmail("aaa");

        try {
            BeanValidators.validateWithException(validator, customer);
            failBecauseExceptionWasNotThrown(ConstraintViolationException.class);
        } catch (ConstraintViolationException e) {
            Map mapResult = BeanValidators.extractPropertyAndMessage(e);
            assertThat(mapResult).contains(entry("email", "not a well-formed email address"),
                    entry("name", "may not be empty"));
        }
    }

    @SuppressWarnings("unused")
    private static class Customer {

        private String name;

        private String email;

        @NotBlank
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Email
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
}
