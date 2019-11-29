package com.moritzb.swcmdemo2.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class Address {

    @Column(name = "STREET_NO", length = 50, nullable = false)
    private String streetNo;

    @Column(name = "ZIP_CODE", length = 50, nullable = false)
    private String zipCode;

    @Column(name = "CITY", length = 50, nullable = false)
    private String city;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;
}
