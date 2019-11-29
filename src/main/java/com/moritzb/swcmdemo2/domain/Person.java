package com.moritzb.swcmdemo2.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
