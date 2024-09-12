package fr.alpacha.webapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    private String phone;

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
