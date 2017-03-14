/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Polissa;

/**
 *
 * @author Matias
 */
public class Polissa_Controller {

    /**
     * Metodo que inserta una Polissa a la BBDD que le llega por parametro
     *
     * @param p
     */
    public void insertar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que modifica una Polissa a la BBDD que le llega por parametro
     *
     * @param p
     */
    public void modificar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que elimina una Polissa a la BBDD que le llega por parametro
     *
     * @param p
     */
    public void eliminar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Método para buscar la poliza
     *
     * @param idPolissa
     * @return
     */
    public Polissa buscar(Long idPolissa) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Polissa p = (Polissa) em.find(Polissa.class, idPolissa);
        System.out.println("close");
        em.close();
        return p;
    }

    /**
     * Método que devuelve la poliza de un vehiculo que le llega por parametro.
     *
     * @param idVehicle
     * @return
     */
    public Polissa buscarPolizaVehicle(Long idVehicle) {
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("buscarPolizaVehicle", Polissa.class);
        query.setParameter("vehicle", idVehicle);
        Polissa p = (Polissa) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }

    /**
     * Busca poliza por el cliente que le llega por parametro su id.
     *
     * @param id
     * @return
     */
    public List<Polissa> buscarPerClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("buscarPolizaCliente", Polissa.class);
        query.setParameter("id", id);
        List<Polissa> polizaLista = (List<Polissa>) query.getResultList();
        System.out.println(polizaLista);
        System.out.println("close");
        em.close();
        return polizaLista;
    }
}
