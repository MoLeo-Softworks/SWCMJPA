package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.LegacyEntity;
import com.moritzb.swcmdemo2.persistence.LegacyEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assumptions.assumeThat;

@DataJpaTest
public class LegacyEntityRepositoryTest {
    @Autowired
    LegacyEntityRepository repository;

    @Test
    void ensureSaveWorks() {
        LegacyEntity entity = LegacyEntity.builder()
                .key(10L)
                .checkDigit("A")
                .value("Super!")
                .build();

        LegacyEntity saved = repository.saveAndFlush(entity);

        assumeThat(saved).isNotNull();
    }
}
