package com.moneytransfer.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.moneytransfer.core.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractEntity {
    private String name;

    @Column(unique = true)
    private String accountId;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date openDate;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date closeDate;

    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "id"))
    private List<Transaction> transactions = new ArrayList<>();
}
