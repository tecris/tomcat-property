package org.terra.tomcat.pr;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.terra.tomcat.pr.entity.Planet;

@Path("/planet")
public class PlanetService {

    private EntityManager em = EMF.createEntityManager();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Planet entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {
        Planet entity = em.find(Planet.class, id);
        if (entity == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        em.remove(entity);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        TypedQuery<Planet> findByIdQuery = em
                .createQuery("SELECT DISTINCT p FROM Planet p WHERE p.id = :entityId ORDER BY p.id", Planet.class);
        findByIdQuery.setParameter("entityId", id);
        Planet entity;
        try {
            entity = findByIdQuery.getSingleResult();
        } catch (NoResultException nre) {
            entity = null;
        }
        if (entity == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(entity).build();
    }
}
