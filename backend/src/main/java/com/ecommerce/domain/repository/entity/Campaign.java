package com.ecommerce.domain.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="campaign")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campaign_id")
    private Long campaignId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private DABOUser user;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="target")
    private String target;

    @Column(name="amount")
    private int amount;

    @Column(name="dead_line")
    private String deadLine;

    @Column(name="media_url")
    private String mediaUrl;

    @Column(name="wallet_address")
    private String walletAddress;

    @ApiParam(value = "현재 기부 받은 헌혈증 수")
    private int receiveBloodCard;

    @ApiParam(value = "현재 기부 받은 Dabo 수")
    private int receiveDabo;

    @Builder.Default
    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"campaign"})
    private List<Comment> comments = new ArrayList<>();
}
