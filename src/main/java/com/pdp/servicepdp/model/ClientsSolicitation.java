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

    public ClientsSolicitation() {
    }

    public ClientsSolicitation(int id, Client client, Solicitation solicitation) {
        this.id = id;
        this.client = client;
        this.solicitation = solicitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Solicitation getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }
}
