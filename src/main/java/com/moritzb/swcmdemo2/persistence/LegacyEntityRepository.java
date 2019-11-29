package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.LegacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegacyEntityRepository extends JpaRepository<LegacyEntity, LegacyEntity.LegacyPrimaryKey> {
}
