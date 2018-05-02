package sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.services.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import sv.edu.ues.fmocc.ingenieria.tpi135.mantenimiento.mantenimientolib.entity.Responsable;

/**
 *
 * @author ale
 */
public class ResponsableTest {
    
    private ResponsableFacade rf;
    
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.persistenceUnit("mantenimientoTestPU");
    
    @BeforeClass
    public void init(){
        ResponsableFacade rf = new ResponsableFacade();
        Whitebox.setInternalState(rf, "em", emp.em());
    }
    
    
    @Test
    public void findByName(){
        rf.getEntityManager().getTransaction().begin();
        
        Responsable nuevo1 = new Responsable(1, "Juanito", "Estuvo aqui", true);
        Responsable nuevo2 = new Responsable(2, "Pepito", "Estuvo aqui", true);
        Responsable nuevo3 = new Responsable(3, "Nadie", "ASAs", true);
             
        rf.getEntityManager().persist(nuevo1);
        rf.getEntityManager().persist(nuevo2);
        rf.getEntityManager().persist(nuevo3);
        
        Assert.assertEquals(3, rf.findAll().size());
        
        List<Responsable> resultado = rf.findListResponsableLike("sA");
        
        List<Responsable> expected = new ArrayList<>();
//        expected.add(nuevo1);
        expected.add(nuevo3);
       
        resultado.stream().forEach(t->{
            System.out.println(t.getNombre());
        });
        
        Assert.assertEquals(resultado.size(),expected.size());
        
    }
    
    
}
