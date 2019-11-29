package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
