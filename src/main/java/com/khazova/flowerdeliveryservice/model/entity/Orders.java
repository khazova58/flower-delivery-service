package com.khazova.flowerdeliveryservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    @Column(name = "address_client")
    private String addressClient;

    @Column(name = "address_delivery")
    private String addressDelivery;

    @Column(name = "status_order")
    private String statusOrder;

    @Column(name = "version_order")
    private int versionOrder;

    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @Column(name = "date_of_update")
    private Date dateOfUpdate;
}
