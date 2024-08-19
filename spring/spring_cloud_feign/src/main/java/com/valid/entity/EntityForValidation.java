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
public class EntityForValidation {

    @NotNull
    private EntityAvailability entityAvailability;
    private long anyLong;
    @NotNull
    private BigDecimal minRange;
    @NotNull
    private BigDecimal maxRange;
    @Valid
    @NotNull(groups = EntityPriorityGroup.class)
    private EntityPriority entityPriority;
    @NotNull
    private BigDecimal minDuration;
    @NotNull
    private BigDecimal maxDuration;
    @NotNull
    private String precisionRange;
    @NotNull(groups = {Default.class, EntityPriorityGroup.class})
    private String methodId;
    private int jobId;
    private int channelId;
    @Valid
    @NotEmpty(groups = EntityInfoGroup.class)
    private List<EntityInfo> entityInfo;

    @Data
    public static class EntityPriority {
        @NotNull(groups = EntityPriorityGroup.class)
        private BigDecimal duration;
        @Valid
        @NotEmpty(groups = EntityPriorityGroup.class)
        private List<Item> items;

        @Data
        public static class Item {
            @NotNull(groups = EntityPriorityGroup.class)
            private BigDecimal priority;
            @NotNull(groups = EntityPriorityGroup.class)
            private BigDecimal somePriority;
        }
    }

    @Data
    public static class EntityInfo {
        @NotNull(groups = EntityInfoGroup.class)
        private BigDecimal minAmount;
        @NotNull(groups = EntityInfoGroup.class)
        private BigDecimal maxAmount;
        @Valid
        @NotEmpty(groups = EntityInfoGroup.class)
        private List<Parameter> parameters;

        @Data
        public static class Parameter {
            @NotNull(groups = EntityInfoGroup.class)
            private BigDecimal duration;
            @NotNull(groups = EntityInfoGroup.class)
            private BigDecimal chargeAmount;
        }
    }

    public enum EntityAvailability {
        CONDITIONALLY_AVAILABLE,
        AVAILABLE,
        UNAVAILABLE,
        AVAILABLE_DUPLICATE
    }

    public interface EntityInfoGroup extends Default {}

    public interface EntityPriorityGroup {}

}
