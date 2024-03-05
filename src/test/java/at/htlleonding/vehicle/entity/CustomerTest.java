package at.htlleonding.vehicle.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void createCustomer() {

        var susi = new Customer("Susi", LocalDate.now());
        System.out.println(susi);
        assertThat(susi.getName()).isEqualTo("Susi");

    }
}