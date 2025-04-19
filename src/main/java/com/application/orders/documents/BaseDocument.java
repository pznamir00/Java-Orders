package com.application.orders.documents;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EntityListeners;
import java.time.Instant;

@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDocument {
    @Id
    private String id;

    @Version
    private int version;

    @Field("createdAt")
    @CreatedDate
    private Instant createdAt;

    @Field("updatedAt")
    @LastModifiedDate
    private Instant updatedAt;
}
