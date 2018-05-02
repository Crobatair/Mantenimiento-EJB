/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.services.dao;

import java.util.List;


/**
 *
 * @author ale
 */
public interface AbstractFacadeInterface<T> {
    
    T create(T entity);

    boolean crear(T entity);
    
    T edit(T entity);
    
    boolean modificar(T entity);

    T remove(T entity);

    boolean eliminar (T entity);
    
    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
    
    
}
