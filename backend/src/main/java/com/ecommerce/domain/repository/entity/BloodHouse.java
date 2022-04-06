package com.ecommerce.domain.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="blood_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode
public class BloodHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bloodhouse_id")
    private Long bloodHouseId;

    @Column(name="net")
    private String net;

    @Column(name="housename")
    private String housename;

    @Column(name="address")
    private String address;

    @Column(name="telephone")
    private String telephone;

}
