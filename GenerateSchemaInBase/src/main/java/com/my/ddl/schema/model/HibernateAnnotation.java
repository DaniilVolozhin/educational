package com.my.ddl.schema.model;

import lombok.Getter;

public enum HibernateAnnotation {
    ENTITY("javax.persistence.Entity"),
    ID("javax.persistence.Id"),
    GENERATED_VALUE("javax.persistence.GeneratedValue"),
    COLUMN("javax.persistence.Column"),
    ONE_TO_ONE("javax.persistence.OneToOne"),
    MANY_TO_ONE("javax.persistence.ManyToOne"),
    MANY_TO_MANY("javax.persistence.ManyToMany");

    @Getter
    private final String pathAnnotation;

    HibernateAnnotation(String pathAnnotation) {
        this.pathAnnotation = pathAnnotation;
    }
}
