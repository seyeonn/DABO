package com.ecommerce.domain.repository.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"password"})
public class DABOUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(name = "nickname",unique = true, nullable = false)
    String nickname;

    String username;

    String bloodType;

    @Column(name = "email",unique = true, nullable = false)
    String email;

    String password;

    Long point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"user"})
    @ToString.Exclude
    private List<BloodCard> bloodCards = new ArrayList<>();
}
