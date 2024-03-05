package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import at.htlleonding.vehicle.entity.dto.VehicleDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class VehicleRepository {

    @Inject
    EntityManager em;

    /**
     * Da Ergebnis nicht typisiert ist -> BÖSE
     * SO MACHT M AN ES NICHT
     */
    public List findAllByQuery() {
        Query query = em.createQuery("select v from Vehicle v");
        List vehicles = query.getResultList();
        return vehicles;
    }

    public List<Vehicle> findAllByTypedQuery() {
        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }

    public List<Vehicle> findAllByNamedQuery() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public List<Vehicle> findAllByNamedQueryWithParameters(String brand) {
        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findByBrand", Vehicle.class)
                .setParameter("brand", brand);
        return query.getResultList();
    }

    public List<Vehicle> findAllByNamedQueryWithPositionalParameters(String brand) {
        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findByBrandWithPositionalParameter", Vehicle.class)
                .setParameter(1, brand);
        return query.getResultList();
    }

    public List<Vehicle> findAllByNativeQuery() {
        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findNativeAll", Vehicle.class);
        return query.getResultList();
    }

    public List<VehicleDto> findAllWithDto() {
        TypedQuery<VehicleDto> query = em
                .createQuery("select NEW at.htlleonding.vehicle.entity.dto.VehicleDto(v.brand, v.model) from Vehicle v", VehicleDto.class);
        return query.getResultList();
    }

}
