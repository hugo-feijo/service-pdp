package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLIENTS_SOLICITATION")
public class ClientsSolicitation implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_solicitation")
    private Solicitation solicitation;
}
