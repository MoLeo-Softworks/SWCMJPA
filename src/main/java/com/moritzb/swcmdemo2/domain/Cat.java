package com.moritzb.swcmdemo2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "CATS")
public class Cat extends Animal {

    @Column(name = "PURRS_PER_MINUTE")
    private Integer purrsPerMinute;

    @ManyToOne
    private Person owner;
}
