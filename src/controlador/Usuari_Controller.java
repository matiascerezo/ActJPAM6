/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Usuari;

/**
 *
 * @author Matias
 */
public class Usuari_Controller {

    /**
     * Método para insertar el usuario que le llega por parametro.
     *
     * @param u
     */
    public void Insertar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(u);

        System.out.println("commit");
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Método para modificar el usuario que le llega por parametro.
     *
     * @param u
     */
    public void Modificar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Método para eliminar el usuario que le llega por parametro.
     *
     * @param u
     */
    public void Eliminar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(u) ? u : em.merge(u));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Método para buscar el usuario correspondiente con el id que le llega 
     * por parametro y devuelve el objeto Usuari.
     *
     * @param id
     * @return
     */
    public Usuari Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Usuari u = (Usuari) em.find(Usuari.class, id);
        System.out.println("close");
        em.close();
        return u;
    }

    /**
     * Torna un boolean si existeix l'usuari o no.
     *
     * @param u
     * @return
     */
    public boolean usuariExisteix(Usuari u) {
        return u == null;
    }
}
