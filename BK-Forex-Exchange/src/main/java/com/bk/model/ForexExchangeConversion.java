package com.bk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name ="exchange" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForexExchangeConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "cfrom")
    private String from;
    @Column(name = "cto")
    private String to;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "total")
    private BigDecimal total;
}
