package com.ecommerce.domain.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Long reservationId;

    @Column(name="housename")
    private String housename;

    @Column(name="address")
    private String address;

    @Column(name="telephone")
    private String telephone;

    @Column(name="blood_date")
    private String bloodDate;

    @Column(name="blood_time")
    private String bloodTime;

    @Column(name="blood_type")
    private String bloodType;
}
