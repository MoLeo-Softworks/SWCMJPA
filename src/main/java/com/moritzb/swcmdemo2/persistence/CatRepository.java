package com.moritzb.swcmdemo2.persistence;

import com.moritzb.swcmdemo2.domain.Cat;
import com.moritzb.swcmdemo2.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {
    public List<Cat> findByOwner(Person owner);
}
