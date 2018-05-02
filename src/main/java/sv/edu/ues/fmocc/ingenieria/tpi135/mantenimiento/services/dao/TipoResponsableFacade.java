/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.services.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.mantenimientolib.entity.TipoResponsable;

/**
 *
 * @author ale
 */
@Stateless
public class TipoResponsableFacade extends AbstractFacade<TipoResponsable> implements TipoResponsableFacadeLocal {

    @PersistenceContext(unitName = "mantenimiento-ejb-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoResponsableFacade() {
        super(TipoResponsable.class);
    }
    
}
