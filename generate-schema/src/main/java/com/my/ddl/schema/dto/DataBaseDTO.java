package com.my.ddl.schema.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class DataBaseDTO {
    @NotNull
    private UUID dataBaseId;
}
