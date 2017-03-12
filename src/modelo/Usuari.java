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
 * @author Matias
 */

/**
 * Clase que crea la tabla "JPAUSUARI" indicando las columnas que debe
 * tener dicha tabla. También tenemos los getters y setters de atributos.
 */

@Entity
@Table(name = "JPAUSUARI")
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuariId", unique = true)
    private Long id;

    @Column(name = "nomUsuari", length = 30, nullable = false)
    private String nom;

    
    @Column(name = "contrasenya", length = 30, nullable = false)
    private String contrasenya;

    public Usuari() {
    }

    public Usuari(String nom, String contrasenya) {
        this.nom = nom;
        this.contrasenya = contrasenya;
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

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   


}
