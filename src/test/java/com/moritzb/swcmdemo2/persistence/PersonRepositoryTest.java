package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository repository;

    @Test
    public void ensureSaveWorks() {
        Country austria = Country.builder().name("AT").build();
        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().zipCode("1130").city("Vienna").country(austria).streetNo("Diabelligasse 7").build());
        List<Cat> cats = new ArrayList<>();
        cats.add(Cat.builder().name("Fiffa").purrsPerMinute(50).build());

        Person p = Person.builder()
                .firstName("Klaus")
                .lastName("Unger")
                .salary(100)
                .ethnic(Ethnic.ROMAN_CATHOLIC)
                .workAddress(
                        Address.builder()
                                .streetNo("Hauptstrasse 1")
                                .city("Ebenfurth")
                                .zipCode("2490")
                                .country(austria)
                                .build()
                )
                .billingAddress(
                        Address.builder()
                                .streetNo("Hauptstrasse 37")
                                .city("Ebenfurth")
                                .zipCode("2490")
                                .country(austria)
                                .build()
                )
                .otherAddresses(addresses)
                .cats(cats)
                .build();

        assertThat(p.getId()).isNull();
        assertThat(p.getVersion()).isNull();

        Person saved = repository.save(p);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getVersion()).isNotNull();
    }
}
