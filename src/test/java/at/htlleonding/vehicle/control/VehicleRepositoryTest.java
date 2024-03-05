package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository vehicleRepository;

    @Test
    void listAllVehicleByTypedQuery() {
        var vehicles = vehicleRepository.findAllByTypedQuery();
        System.out.println(vehicles);
        assertThat(vehicles).hasSize(3)
                .extracting(Vehicle::getBrand)
                .contains("Opel", "VW", "Opel");
    }

    @Test
    void listAllVehicleByNamedQuery() {
        var vehicles = vehicleRepository.findAllByNamedQuery();
        System.out.println(vehicles);
        assertThat(vehicles).hasSize(3)
                .extracting(Vehicle::getBrand)
                .contains("Opel", "VW");
    }

    @Test
    void listAllVehicleByNamedQueryWithParameters() {
        var vehicles = vehicleRepository.findAllByNamedQueryWithParameters("Opel");
        System.out.println(vehicles);
        assertThat(vehicles).hasSize(2)
                .extracting(Vehicle::getBrand)
                .contains("Opel");
    }

    @Test
    void listAllVehicleByNamedQueryWithPositionalParameters() {
        var vehicles = vehicleRepository.findAllByNamedQueryWithPositionalParameters("Opel");
        System.out.println(vehicles);
        assertThat(vehicles).hasSize(2)
                .extracting(Vehicle::getBrand)
                .contains("Opel");
    }

    @Test
    void listAllVehiclesNative() {
        var vehicles = vehicleRepository.findAllByNativeQuery();
        System.out.println(vehicles);
        assertThat(vehicles).hasSize(3)
                .extracting(Vehicle::getBrand)
                .contains("Opel");
    }

    @Test
    void findAllWithDto() {
        var vehicles = vehicleRepository.findAllWithDto();
        System.out.println(vehicles);
    }
}