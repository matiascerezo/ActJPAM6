package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Matias
 */

/**
 * Clase que crea la tabla "JPAPOLISSA" indicando las columnas que debe
 * tener dicha tabla. También tenemos los getters y setters de atributos y las
 * diferentes Querys para realizar las consultas.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "buscarPolizaCliente", query = "SELECT p FROM JPAPOLISSA p WHERE p.prenedor.id=:id"),
    @NamedQuery(name = "buscarPolizaVehicle", query = "SELECT p FROM JPAPOLISSA p WHERE p.vehicle.vehicleId=:vehicle")})
@Table(name = "JPAPOLISSA", indexes = {
    @Index(columnList = "prenedor", name = "indexPrenedor")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId", unique = true)
    private Long id;

    @Column(name = "numPolissa", length = 10, nullable = false, unique = true)
    private String numPolissa;

    @ManyToOne
    @JoinColumn(name = "prenedor", nullable = false)
    private Client prenedor;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    @Column(name = "dataInici", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInici;

    @Column(name = "dataFi", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFi;

    @Column(name = "tipus")
    @Enumerated(EnumType.STRING)
    private TipusPolissa tipus;

    @Column(name = "prima", precision = 2)
    private double prima;

    public Polissa(String numPolissa, Client prenedor, Vehicle vehicle, Date dataInici, Date dataFi, TipusPolissa tipus, double prima) {
        this.numPolissa = numPolissa;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }

    public Polissa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumPolissa() {
        return numPolissa;
    }

    public void setNumPolissa(String numPolissa) {
        this.numPolissa = numPolissa;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public TipusPolissa getTipus() {
        return tipus;
    }

    public void setTipus(TipusPolissa tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Polissa other = (Polissa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "id=" + id + ", numPolissa=" + numPolissa + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + '}';
    }
}
