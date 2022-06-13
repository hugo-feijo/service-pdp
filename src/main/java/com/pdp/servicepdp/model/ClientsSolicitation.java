package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS_SOLICITATION")
public class ClientsSolicitation implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_client",nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitation",nullable = false)
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

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsSolicitation clientsSolicitation = (ClientsSolicitation) o;
        return id == clientsSolicitation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
