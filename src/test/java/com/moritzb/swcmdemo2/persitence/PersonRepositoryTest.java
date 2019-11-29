package com.moritzb.swcmdemo2.persitence;

import com.moritzb.swcmdemo2.domain.Ethnic;
import com.moritzb.swcmdemo2.domain.Person;
import com.moritzb.swcmdemo2.persistence.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository repository;

    @Test
    public void ensureSaveWorks() {
        Person p = Person.builder().firstName("Klaus").lastName("Unger").salary(100).ethnic(Ethnic.ROMAN_CATHOLIC).build();

        assertThat(p.getId()).isNull();
        assertThat(p.getVersion()).isNull();

        Person saved = repository.saveAndFlush(p);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getVersion()).isNotNull();
    }
}
