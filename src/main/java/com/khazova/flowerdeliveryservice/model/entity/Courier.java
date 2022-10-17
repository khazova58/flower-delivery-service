package com.khazova.flowerdeliveryservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "couriers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Courier {

    @OneToMany(mappedBy = "courier")
    private List<Orders> orders;

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "courier_id", unique = true)
    private String courierID;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Courier(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
