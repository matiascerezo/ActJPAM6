/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Asseguradora;

/**
 *
 * @author Matias
 */
public class Asseguradora_Controller {

    /**
     * Metodo que inserta una Asseguradora a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void insertar(Asseguradora a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que modifica una Asseguradora a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void modificar(Asseguradora a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que elimina una Asseguradora a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void eliminar(Asseguradora a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(a) ? a : em.merge(a));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que busca una Asseguradora a la BBDD que le llega por parametro
     *
     * @param id
     * @return
     */
    public Asseguradora buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Asseguradora a = (Asseguradora) em.find(Asseguradora.class, id);
        System.out.println("close");
        em.close();
        return a;
    }
}
