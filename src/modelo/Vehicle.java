package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Matias
 */

/**
 * Clase que crea la tabla "JPAVEHICLE" indicando las columnas que debe
 * tener dicha tabla. También tenemos los getters y setters de atributos y las
 * diferentes Querys para realizar las consultas.
 */
@Entity
@NamedQueries({
@NamedQuery(name = "buscarPorMatricula", query = "Select v FROM JPAVEHICLE v WHERE v.matricula=:matricula")})
@Table(name = "JPAVEHICLE" , indexes = {@Index(columnList = "matricula", name = "indexMatricula")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId", unique = true)
    private Long id;
    
    @Column(name = "matricula", length = 7, nullable = false, unique = true)
    private String matricula;
        
    @Column(name = "marca_model", length = 40)
    private String marca;
    
    @Column(name = "anyFabricacio")
    private String anyFabricacio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietari")
    private Client client;

    public Vehicle() {
    }

    public Vehicle(String matricula, String marca, String anyFabricacio, Client client) {
        this.matricula = matricula;
        this.marca = marca;
        this.anyFabricacio = anyFabricacio;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnyFabricacio() {
        return anyFabricacio;
    }

    public void setAnyFabricacio(String anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", matricula=" + matricula + ", anyFabricacio=" + anyFabricacio + ", marca=" + marca + ", client=" + client + '}';
    }
}