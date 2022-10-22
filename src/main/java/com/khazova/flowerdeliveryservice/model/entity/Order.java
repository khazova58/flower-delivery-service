package com.khazova.flowerdeliveryservice.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность для работы с Orders
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id")
    private String orderID;

    @Column(name = "address_client")
    private String addressClient;

    @Column(name = "address_delivery")
    private String addressDelivery;

    @Column(name = "status_order")
    private String statusOrder = "Новый";

    @Version
    @Column(name = "version_order")
    private int versionOrder;

    @CreationTimestamp
    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @UpdateTimestamp
    @Column(name = "date_of_update")
    private Date dateOfUpdate;

    public Order(Courier courier, Client client, String addressClient, String addressDelivery) {
        this.courier = courier;
        this.client = client;
        this.addressClient = addressClient;
        this.addressDelivery = addressDelivery;
    }
}
