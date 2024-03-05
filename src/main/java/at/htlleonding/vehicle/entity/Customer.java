package at.htlleonding.vehicle.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "V_CUSTOMER")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dob;

    public Customer() {
    }

    public Customer(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%d: %s (%tA, %tD)", id, name, dob, dob);
    }
}
