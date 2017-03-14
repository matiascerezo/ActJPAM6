package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Matias
 */

/**
 * Clase que crea la tabla "JPACLIENT" indicando las columnas que debe
 * tener dicha tabla. También tenemos los getters y setters de atributos y las
 * diferentes Querys para realizar las consultas.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "buscarClient", query = "SELECT c FROM Client c WHERE c.nomClient=:nomClient")})
@Table(name = "JPACLIENT")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId", unique = true)
    private Long id;

    @Column(name = "nifClient", length = 9, nullable = false, unique = true)
    private String nif;

    @Column(name = "nomClient", length = 20, nullable = false)
    private String nom;

    @Embedded
    private Adreca adreca;

    public Client() {
    }

    public Client(String nif, String nom, Adreca adreca) {
        this.nif = nif;
        this.nom = nom;
        this.adreca = adreca;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nif=" + nif + ", nom=" + nom + ", adreca=" + adreca + '}';
    }
}
