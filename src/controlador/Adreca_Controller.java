package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Adreca;

public class Adreca_Controller {

    /**
     * Metodo que inserta una Adreça a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void Insertar(Adreca a) {
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
     * Metodo que modifica una Adreça a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void Modificar(Adreca a) {
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
     * Metodo que elimina una Adreça a la BBDD que le llega por parametro
     *
     * @param a
     */
    public void Eliminar(Adreca a) {
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
     * Metodo que busca una Adreça a la BBDD correspondiente con el id que le
     * llega por parametro y devuelve el objeto Adreca.
     *
     * @param id
     * @return 
     */
    public Adreca Buscar(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        Adreca a = (Adreca) em.find(Adreca.class, id);
        System.out.println("close");
        em.close();
        return a;
    }
}
