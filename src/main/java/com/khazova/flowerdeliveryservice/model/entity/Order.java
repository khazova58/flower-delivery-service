package com.khazova.flowerdeliveryservice.model.entity;

import com.khazova.flowerdeliveryservice.model.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Сущность для работы с таблицей Orders
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "address_client")
    private String addressClient;

    @Column(name = "address_delivery")
    private String addressDelivery;

    @Column(name = "status_order")
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;

    @Version
    @Column(name = "version_order")
    private int versionOrder;

    @CreationTimestamp
    @Column(name = "date_of_order")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "date_of_update")
    private Date dateOfUpdate;

    public Order(Client client, String addressClient, String addressDelivery) {
        this.client = client;
        this.addressClient = addressClient;
        this.addressDelivery = addressDelivery;
    }

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", orderID='" + orderId + '\'' +
                ", addressClient='" + addressClient + '\'' +
                ", addressDelivery='" + addressDelivery + '\'' +
                ", status=" + status +
                ", versionOrder=" + versionOrder +
                ", dateOfOrder=" + createDateTime +
                '}';
    }
}
