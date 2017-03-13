/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Client;
import modelo.Polissa;

/**
 *
 * @author Matias
 */
public class Client_Controller {

    /**
     * Metodo que inserta un cliente a la BBDD que le llega por parametro
     *
     * @param c
     */
    public void insertar(Client c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que modifica un cliente a la BBDD que le llega por parametro
     *
     * @param c
     */
    public void modificar(Client c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Metodo que elimina un cliente a la BBDD que le llega por parametro
     *
     * @param c
     */
    public void eliminar(Client c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(c) ? c : em.merge(c));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Método que busca un cliente a la BBDD que le llega por parametro,
     * devuelve el Cliente
     *
     * @param id
     * @return
     */
    public Client buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Client c = (Client) em.find(Client.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    /**
     * Busca poliza por el cliente que le llega por parametro su nombre.
     *
     * @param nom
     * @return
     */
    public Client buscarClientPerNom(String nom) {
        EntityManager em = new EM_Controller().getEntityManager();
        Query query = em.createNamedQuery("buscarClient", Client.class);
        query.setParameter("nomClient", nom);
        Client c = (Client) query.getResultList();
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }
}
