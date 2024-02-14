package com.educational;

import com.valid.entity.EntityForValidation;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;


public class ValidationTest {

//    @BeforeEach
//    public void setupValidatorInstance() {
//        validator = Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator();
//    }

    @Test
    public void whenBasicInfoIsNotComplete_thenShouldGiveConstraintViolationsOnlyForBasicInfo() {
        Validator validator = Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator();

        EntityForValidation entityForValidation = buildRegistrationFormWithBasicInfo();

        Set<ConstraintViolation<EntityForValidation>> violations =
                validator.validate(entityForValidation, EntityForValidation.EntityInfoGroup.class, EntityForValidation.EntityPriorityGroup.class);

        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getMessage()).isEqualTo("must not be blank");
            assertThat(action.getPropertyPath().toString()).isEqualTo("firstName");
        });
    }

    private EntityForValidation buildRegistrationFormWithBasicInfo() {
        EntityForValidation entityForValidation = new EntityForValidation();
        var promPrior = new EntityForValidation.EntityPriority()
                .setItems(of(new EntityForValidation.EntityPriority.Item()
                        .setSomePriority(BigDecimal.TEN).setPriority(BigDecimal.ONE)))
                .setDuration(BigDecimal.TEN);
        entityForValidation.setEntityPriority(promPrior);
        var cus = new EntityForValidation.EntityInfo()
                .setParameters(of(new EntityForValidation.EntityInfo.Parameter()
                        .setDuration(BigDecimal.TEN)
                        .setChargeAmount(BigDecimal.ONE)))
                .setMaxAmount(BigDecimal.ONE)
                .setMinAmount(BigDecimal.TEN);
        entityForValidation.setEntityInfo(
                of(cus));
        entityForValidation.setMethodId("");
        entityForValidation.setMaxDuration(BigDecimal.ONE);
        entityForValidation.setMinDuration(BigDecimal.ONE);
        entityForValidation.setMaxRange(BigDecimal.ONE);
        entityForValidation.setMinRange(BigDecimal.ONE);
        entityForValidation.setPrecisionRange("");
        return entityForValidation;
    }

}