/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.services.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.mantenimientolib.entity.Responsable;

/**
 *
 * @author ale
 */
@Stateless
public class ResponsableFacade extends AbstractFacade<Responsable> implements ResponsableFacadeLocal {

    @PersistenceContext(unitName = "mantenimiento-ejb-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableFacade() {
        super(Responsable.class);
    }

    @Override
    public List<Responsable> findListResponsableLike(String name) {
        if (name != null && getEntityManager() != null) {
            String filter =     "%" + name.toLowerCase() + "%";
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Responsable> query = builder.createQuery(Responsable.class);
            Root<Responsable> root = query.from(Responsable.class);
            Predicate findLikeName = builder.or(builder.like(builder.lower(root.<String>get("nombre")),filter),builder.like(builder.lower(root.<String>get("primerApellido")),filter),builder.like(builder.lower(root.<String>get("segundoApellido")),filter));
            query.select(root).where(findLikeName);
            return getEntityManager().createQuery(query).getResultList();
        } else {
            return null;
        }
    }


}
