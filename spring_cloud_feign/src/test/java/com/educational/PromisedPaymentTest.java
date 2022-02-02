package com.educational;

import com.valid.entity.PromisedPayment;
import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class PromisedPaymentTest {

//    @BeforeEach
//    public void setupValidatorInstance() {
//        validator = Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator();
//    }

    @Test
    public void whenBasicInfoIsNotComplete_thenShouldGiveConstraintViolationsOnlyForBasicInfo() {
        Validator validator = Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator();

        PromisedPayment promisedPayment = buildRegistrationFormWithBasicInfo();

        Set<ConstraintViolation<PromisedPayment>> violations =
                validator.validate(promisedPayment, PromisedPayment.CustomizedPromisedPaymentInfoGroup.class, PromisedPayment.PromisedPaymentPriorityGroup.class);

        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getMessage()).isEqualTo("must not be blank");
            assertThat(action.getPropertyPath().toString()).isEqualTo("firstName");
        });
    }

    private PromisedPayment buildRegistrationFormWithBasicInfo() {
        PromisedPayment promisedPayment = new PromisedPayment();
        var promPrior = new PromisedPayment.PromisedPaymentPriority()
//                .setItems(of(new PromisedPayment.PromisedPaymentPriority.Item()
//                        .setChargeAmountPriority(BigDecimal.TEN).setAmountPriority(BigDecimal.ONE)))
                .setDuration(BigDecimal.TEN);
        promisedPayment.setPromisedPaymentPriority(promPrior);
        var cus = new PromisedPayment.CustomizedPromisedPaymentInfo()
                .setParameters(of(new PromisedPayment.CustomizedPromisedPaymentInfo.Parameter()
                        .setDuration(BigDecimal.TEN)
                        .setChargeAmount(BigDecimal.ONE)))
                .setMaxAmount(BigDecimal.ONE)
                .setMinAmount(BigDecimal.TEN);
        promisedPayment.setCustomizedPromisedPaymentInfo(
                of(cus));
//        promisedPayment.setChargeMethodId("");
        promisedPayment.setMaxDuration(BigDecimal.ONE);
        promisedPayment.setMinDuration(BigDecimal.ONE);
        promisedPayment.setMaxRange(BigDecimal.ONE);
        promisedPayment.setMinRange(BigDecimal.ONE);
        promisedPayment.setPrecisionRange("");
        return promisedPayment;
    }

}