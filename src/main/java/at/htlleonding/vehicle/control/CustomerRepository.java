package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;

    public Customer save(Customer customer) {
        return em.merge(customer);
    }


}
