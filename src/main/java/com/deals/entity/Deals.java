package com.deals.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
@Entity
@Table(name = "deals")
public class Deals implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_id", nullable = false, unique = true)
    private String dealID;

    @Column(name = "from_currency", nullable = false, length = 5)
    private String fromCurrency;

    @Column(name = "to_currency", nullable = false, length = 5)
    private String toCurrency;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "deal_amount", nullable = false)
    private BigDecimal dealAmount;

}
