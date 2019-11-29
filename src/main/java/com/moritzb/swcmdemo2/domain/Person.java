package com.moritzb.swcmdemo2.domain;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "PEOPLE", indexes = {@Index(name = "X_LAST_NAME", columnList = "LAST_NAME")})
@SecondaryTables({
        @SecondaryTable(
                name = "PERSON_ETHNICS",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID"),
                foreignKey = @ForeignKey(name = "FK_PERSON_EHTNICS_TO_PEOPLE")
        ),
        @SecondaryTable(
                name = "PERSON_SALARIES",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID"),
                foreignKey = @ForeignKey(name = "FK_PERSON_SALARIES_TO_PEOPLE")
        )
})
public class Person {
    @Id
    @SequenceGenerator(name = "SEQ_PEOPLE", sequenceName = "SEQ_PEOPLE", initialValue = 1000, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEOPLE")
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    @NotNull
    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "SALARY", table = "PERSON_SALARIES", nullable = false)
    private Integer salary;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ETHNIC", table = "PERSON_ETHNICS", nullable = false)
    private Ethnic ethnic;

    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "streetNo", column = @Column(name = "WA_STREET_NO", nullable = false)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "WA_ZIP_CODE", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "WA_CITY", nullable = false))
    })
    @AssociationOverride(name = "country", joinColumns = @JoinColumn(name = "WA_COUNTRY_ID"))
    @Embedded
    private Address workAddress;

    @Nullable
    @AttributeOverrides({
            @AttributeOverride(name = "streetNo", column = @Column(name = "BA_STREET_NO")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "BA_ZIP_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "BA_CITY"))
    })
    @AssociationOverride(name = "country", joinColumns = @JoinColumn(name = "BA_COUNTRY_ID"))
    @Embedded
    private Address billingAddress;

    @ElementCollection
    @CollectionTable(
            name = "PERSON_OTHER_ADDRESSES",
            joinColumns = @JoinColumn(name = "PERSON_ID")
    )
    private List<Address> otherAddresses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", orphanRemoval = true)
    private List<Cat> cats;
}
