package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @ConfigProperty(name = "alte.socke")
    String alteSockeState;

    @Transactional
    void startUp(@Observes StartupEvent event) {
        Log.info("it is working");

        Vehicle vehicle = new Vehicle("Opel", "Kadett");
        em.persist(vehicle);

        Log.info("Wie ist die alte Socke -> " + alteSockeState);
    }


}
