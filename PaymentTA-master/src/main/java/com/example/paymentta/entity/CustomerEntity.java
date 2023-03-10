package com.example.paymentta.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@EntityListeners(AuditingEntityListener.class)
public class CustomerEntity extends AbstractEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    private String cardNumber;
    private String accountNumber;
    private Long balance;
    @OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "cardNumber"))
    private List<TransactionEntity> transaction;
}
