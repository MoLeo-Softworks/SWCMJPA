package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.Animal;
import com.moritzb.swcmdemo2.domain.Cat;
import com.moritzb.swcmdemo2.domain.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CatRepositoryTest {
    @Autowired
    CatRepository repository;

    @Test
    void ensureSaveWorks() {
        Cat cat = Cat.builder().name("JT Kirk").purrsPerMinute(100).build();

        Cat saved = repository.save(cat);

        assertThat(saved).isNotNull();
    }
}