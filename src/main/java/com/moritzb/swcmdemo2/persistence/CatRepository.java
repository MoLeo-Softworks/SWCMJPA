package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
