/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Vehicle;

/**
 *
 * @author Matias
 */
public class Vehicle_Controller {

    /**
     * Metodo que inserta un Vehicle a la BBDD que le llega por parametro
     *
     * @param v
     */
    public void Insertar(Vehicle v) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(v);

        System.out.println("commit");
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que modifica un Vehicle a la BBDD que le llega por parametro
     *
     * @param v
     */
    public void Modificar(Vehicle v) {
        // Recupera el entity manager
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(v);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que elimina un Vehicle a la BBDD que le llega por parametro
     *
     * @param v
     */
    public void Eliminar(Vehicle v) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(v) ? v : em.merge(v));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que busca un vehicle por su id y devuelve el objeto Vehicle que
     * corresponde con el id introducido por parametro.
     *
     * @param id
     * @return
     */
    public Vehicle Buscar(long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Vehicle v = (Vehicle) em.find(Vehicle.class, id);
        System.out.println("close");
        em.close();
        return v;
    }

    /**
     * Metodo para buscar un Vehicle por matricula, devuelve el Vehicle
     * correspondiente a la matricula introducida por parametro.
     *
     * @param matricula
     * @return
     */
    public Vehicle buscarPorMatricula(String matricula) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("buscarPorMatricula", Vehicle.class);
        query.setParameter("matricula", matricula);
        Vehicle v = (Vehicle) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }
}
