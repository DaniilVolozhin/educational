package com.valid.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class PromisedPayment {

    private long msisdn;
    @NotNull
    private BigDecimal minRange;
    @NotNull
    private BigDecimal maxRange;
    @Valid
    @NotNull(groups = PromisedPaymentPriorityGroup.class)
    private PromisedPaymentPriority promisedPaymentPriority;
    @NotNull
    private BigDecimal minDuration;
    @NotNull
    private BigDecimal maxDuration;
    @NotNull
    private String precisionRange;
    @NotNull(groups = {Default.class, PromisedPaymentPriorityGroup.class})
    private String chargeMethodId;
    private int ucJobId;
    private int promisedPaymentLogicChannelId;
    @Valid
    @NotEmpty(groups = CustomizedPromisedPaymentInfoGroup.class)
    private List<CustomizedPromisedPaymentInfo> customizedPromisedPaymentInfo;

    @Data
    public static class PromisedPaymentPriority {
        @NotNull(groups = PromisedPaymentPriorityGroup.class)
        private BigDecimal duration;
        @Valid
        @NotEmpty(groups = PromisedPaymentPriorityGroup.class)
        private List<Item> items;

        @Data
        public static class Item {
            @NotNull(groups = PromisedPaymentPriorityGroup.class)
            private BigDecimal amountPriority;
            @NotNull(groups = PromisedPaymentPriorityGroup.class)
            private BigDecimal chargeAmountPriority;
        }
    }

    @Data
    public static class CustomizedPromisedPaymentInfo {
        @NotNull(groups = CustomizedPromisedPaymentInfoGroup.class)
        private BigDecimal minAmount;
        @NotNull(groups = CustomizedPromisedPaymentInfoGroup.class)
        private BigDecimal maxAmount;
        @Valid
        @NotEmpty(groups = CustomizedPromisedPaymentInfoGroup.class)
        private List<Parameter> parameters;

        @Data
        public static class Parameter {
            @NotNull(groups = CustomizedPromisedPaymentInfoGroup.class)
            private BigDecimal duration;
            @NotNull(groups = CustomizedPromisedPaymentInfoGroup.class)
            private BigDecimal chargeAmount;
        }
    }

    public interface CustomizedPromisedPaymentInfoGroup extends Default {}

    public interface PromisedPaymentPriorityGroup {}

}
