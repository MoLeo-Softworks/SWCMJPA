package com.moritzb.swcmdemo2.domain;

import com.sun.istack.NotNull;
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
@Table(name = "COUNTRIES")
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
}
