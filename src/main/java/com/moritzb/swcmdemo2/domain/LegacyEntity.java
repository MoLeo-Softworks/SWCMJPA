package com.moritzb.swcmdemo2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "LEGACY_ENTITIES")
@IdClass(LegacyEntity.LegacyPrimaryKey.class)
public class LegacyEntity {

    @Id
    private Long key;

    @Id
    private String checkDigit;

    @Column(name = "VALUE", length = 20, nullable = false)
    private String value;

    public static class LegacyPrimaryKey implements Serializable {
        @Column(name = "KEY", nullable = false)
        private long key;

        @Column(name = "CHECK_DIGIT", length = 2, nullable = false)
        private String checkDigit;
    }
}
