package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_order_pad", nullable = false)
    private OrderPad orderPad;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<ClientsSolicitation> clientsSolicitation;

    public Client() {
        this.setId(0);
        this.setName("NO NAME");
        this.setCpf("00000000000");
        this.setOrderPad(null);
        this.setClientsSolicitation(new HashSet<>());
    }

    public Client(int id, String name, String cpf, OrderPad orderPad, Set<ClientsSolicitation> clientsSolicitation) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.orderPad = orderPad;
        this.clientsSolicitation = clientsSolicitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public OrderPad getOrderPad() {
        this.orderPad.setClients(null);
        return orderPad;
    }

    public void setOrderPad(OrderPad orderPad) {
        this.orderPad = orderPad;
    }

    public void setClientsSolicitation(Set<ClientsSolicitation> clientsSolicitation) {
        this.clientsSolicitation = clientsSolicitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
