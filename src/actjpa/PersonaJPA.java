/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actjpa;

import controlador.*;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.*;

/**
 *
 * @author Matias
 */
public class PersonaJPA {
    
    public static void main(String[] args) {
        try {
            //Para formatear la fecha
            SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
            //CONTROLADORES
            Polissa_Controller pc = new Polissa_Controller();
            Usuari_Controller uc = new Usuari_Controller();
            Client_Controller cc = new Client_Controller();
            Vehicle_Controller vc = new Vehicle_Controller();
            Asseguradora_Controller ac = new Asseguradora_Controller();
            Adreca_Controller adc = new Adreca_Controller();
            //Creamos los objetos
            //Adreça
            Adreca ad1 = new Adreca();
            ad1.setCarrer("Plaza Pere IV");
            ad1.setNumero(5);
            ad1.setPoblacio("La Llagosta");
            
            //Client
            Client c1 = new Client();
            c1.setNom("Matias");
            c1.setNif("41625810L");
            c1.setAdreca(ad1);
            //Usuari
            Usuari u2 = new Usuari();
            u2.setNom("Matias2");
            u2.setContrasenya("1234");
            //Aseguradora
            Asseguradora a1 = new Asseguradora();
            a1.setId(0L);
            a1.setNom("Aseguradora1");
            a1.setNifcif("45612345U");
            //Vehicle
            Vehicle v1 = new Vehicle();
            v1.setId(0L);
            v1.setMatricula("5451BXB");
            v1.setMarca("OPEL");
            v1.setAnyFabricacio("2010");
            v1.setClient(c1);
            //Polissa
            //Polissa p1 = new Polissa("123", c1, v1, format1.parse("01-03-2017"), format1.parse("01-04-2017"), TipusPolissa.TERCERS, 0);
            Polissa p2 = new Polissa();
            p2.setId(0L);
            p2.setNumPolissa("123");
            p2.setPrenedor(c1);
            p2.setVehicle(v1);
            p2.setDataInici(format1.parse("01-03-2017"));
            p2.setDataFi(format1.parse("01-04-2017"));
            p2.setTipus(TipusPolissa.TERCERS);
            p2.setPrima(0);

            //USUARI
            uc.insertar(u2);//Para insertar un usuario
            Usuari uMod = uc.buscar(321L); //Para buscar el usuario y lo asignamos a uMod.
            uMod.setNom("UsuarioMod");//Para modificar el nombre al usuario
            uMod.setContrasenya("12345");
            uc.modificar(uMod);//Confirmamos las modificaciones en la BD
            uc.eliminar(uMod);//Para eliminar el usuario.

            //CLIENTES
            cc.insertar(c1);
            Client cMod = cc.buscar(301L);//Buscamos el cliente y lo asignamos a la variable cMod
            cMod.setNom("MatiasMod");
            cMod.setNif("45612378L");
            cMod.setAdreca(ad1);
            cc.modificar(cMod);//Confirmamos cambios a la BD.
            //Para eliminar un cliente, como tiene referencias con otras tablas,
            //primero tenemos que quitar esas referencias antes de eliminarlo.
            List<Polissa> PEliminar = pc.buscarPerClient(0L);
            for (int i = 0; i < PEliminar.size(); i++) {
                pc.eliminar(PEliminar.get(i));
            }
            //Una vez hemos eliminado las referencias que tenia, podemos eliminarlo.           
            cc.eliminar(cMod);

            //VEHICLES
            vc.insertar(v1); // Insertem Vehicle
            Vehicle v2 = vc.buscar(0L);
            v2.setMatricula("5451BXH");
            v2.setMarca("OPEL");
            v2.setAnyFabricacio("1996");
            v2.setClient(c1);
            vc.modificar(v2);
            //Pasa lo mismo que en el apartado del cliente, que tiene referencias en otras tablas
            //por tanto, hay que eliminar las referencias.
            Polissa pEli = pc.buscarPolizaVehicle(0L);//Buscamos la poliza por vehiculo por su id.
            pc.eliminar(pEli);
            //Ahora ya no tenemos referencias.
            vc.eliminar(v2);

            //ASSEGURADORA
            ac.insertar(a1);//Insertamos asseguradora
            Asseguradora aMod = ac.buscar(0L);//Busquem asseguradora y la assignamos a la variable aMod.
            aMod.setNom("Asseguradora2");
            aMod.setNifcif("45215212E");
            ac.modificar(aMod);//Confirmamos la modificacion en la BD.    
            ac.eliminar(aMod);

            //POLISSES
            pc.insertar(p2);
            Polissa pMod = pc.buscar(0L);
            pMod.setTipus(TipusPolissa.TOTRISC);//Modificamos el tipo de poliza
            pc.modificar(pMod);
            pc.eliminar(pMod);
            
            System.out.println("FIN");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
