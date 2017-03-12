package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 *
 * @author Matias
 */

/**
 * Clase que crea el objeto Adreca que será utilizado en las diferentes tablas.
 */
@Embeddable
@Table(name = "JPAADRECA")
public class Adreca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "poblacio", length = 50, nullable = false)
    private String poblacio;

    public Adreca() {
    }

    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacio = poblacio;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", numero=" + numero + ", poblacio=" + poblacio + '}';
    }
}
