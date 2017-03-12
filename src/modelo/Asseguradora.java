package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matias
 */
/**
 * Clase que crea la tabla "JPAASSEGURADORA" indicando las columnas que debe
 * tener dicha tabla. También tenemos los getters y setters de atributos.
 */
@Entity
@Table(name = "JPAASSEGURADORA")
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asseguradoraId", unique = true)
    private Long id;

    @Column(name = "nom", length = 100, nullable = false, unique = true)
    private String nom;

    @Column(name = "nifcif")
    private String nifcif;
    
    //@OneToMany(mappedBy = "listAsseguradora")
    //private List<Polissa> polissa;

    public Asseguradora() {
    }

    /**
     * Constructor de Asseguradora
     * @param id
     * @param nom
     * @param nifcif 
     */
    public Asseguradora(Long id, String nom, String nifcif) {
        this.id = id;
        this.nom = nom;
        this.nifcif = nifcif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNifcif() {
        return nifcif;
    }

    public void setNifcif(String nifcif) {
        this.nifcif = nifcif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que compara el id para que no coincida.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asseguradora other = (Asseguradora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + id + ", nom=" + nom + ", nifcif=" + nifcif + '}';
    }
}
