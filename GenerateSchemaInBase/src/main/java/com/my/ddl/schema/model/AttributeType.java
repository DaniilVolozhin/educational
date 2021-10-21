package com.my.ddl.schema.model;

import lombok.Getter;

public enum AttributeType {

    STRING("java.lang.String"),
    LONG("java.lang.Long"),
    FLOAT("java.lang.Float"),
    BOOLEAN("java.lang.Boolean"),
    DATE_WITH_TIMEZONE("java.time.OffsetDateTime")
    ;

    AttributeType(String javaType) {
        this.javaType = javaType;
    }

    @Getter
    private final String javaType;

}
