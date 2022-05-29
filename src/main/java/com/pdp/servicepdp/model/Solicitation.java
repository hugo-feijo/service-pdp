package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "SOLICITATION")
public class Solicitation implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    //itens

    @Column(name = "solicited_at",nullable = false)
    private LocalDateTime solicitedAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;

    @OneToMany(mappedBy = "solicitation")
    private Set<ClientsSolicitation> clientsSolicitation;
}
