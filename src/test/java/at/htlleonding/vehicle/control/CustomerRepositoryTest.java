package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Customer;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;


    @Test
    @Transactional
    void persistCustomer() {

        var customer = new Customer("Susi", LocalDate.of(2006, 5, 5));
        customerRepository.save(customer);

    }
}