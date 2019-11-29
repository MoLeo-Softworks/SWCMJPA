package com.moritzb.swcmdemo2.domain;

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
@Table(name="PEOPLE")
@SecondaryTables({
        @SecondaryTable(name="PERSON_ETHNICS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")),
        @SecondaryTable(name="PERSON_SALARIES", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID"))
})
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "SALARY", table = "PERSON_SALARIES", nullable = false)
    private Integer salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETHNIC", table = "PERSON_ETHNICS", nullable = false)
    private Ethnic ethnic;
}
