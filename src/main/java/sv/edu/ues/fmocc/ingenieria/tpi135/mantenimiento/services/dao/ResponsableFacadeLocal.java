/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.services.dao;

import java.util.List;
import javax.ejb.Local;
import sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.mantenimientolib.entity.Responsable;

/**
 *
 * @author ale
 */
@Local
public interface ResponsableFacadeLocal extends AbstractFacadeInterface<Responsable> {

    public List<Responsable> findListResponsableLike(String name);


    
}
