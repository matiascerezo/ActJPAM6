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
            //Creamos los objetos
            //Adreça
            Adreca ad1 = new Adreca("Plaza Pere IV", 5, "La Llagosta");
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
            Asseguradora a1 = new Asseguradora(2L, "Aseguradora1", "45612345U");
            //Vehicle
            Vehicle v1 = new Vehicle("5451BXB", "OPEL", "2010", c1);
            //Polissa
            Polissa p1 = new Polissa("123", c1, v1, format1.parse("01-03-2017"), format1.parse("01-04-2017"), TipusPolissa.TERCERS, 0);

            //USUARI
            uc.Insertar(u2);//Para insertar un usuario
            Usuari uMod = uc.Buscar(0L); //Para buscar el usuario y lo asignamos a uMod.
            uMod.setNom("UsuarioMod");//Para modificar el nombre al usuario
            uMod.setContrasenya("12345");
            uc.Modificar(uMod);//Confirmamos las modificaciones en la BD
            uc.Eliminar(uMod);//Para eliminar el usuario.
            //Comprobamos que ya no existe
            uc.usuariExisteix(uMod);//Si devuelve true es que si y si devuelve false es que no.

            //CLIENTES
            cc.Insertar(c1);
            Client cMod = cc.Buscar(0L);//Buscamos el cliente y lo asignamos a la variable cMod
            cMod.setNom("MatiasMod");
            cMod.setNif("45612378L");
            cMod.setAdreca(ad1);
            cc.Modificar(cMod);//Confirmamos cambios a la BD.
            //Para eliminar un cliente, como tiene referencias con otras tablas,
            //primero tenemos que quitar esas referencias antes de eliminarlo.
            List<Polissa> PEliminar = pc.buscarPerClient(0L);
            for (int i = 0; i < PEliminar.size(); i++) {
                pc.Eliminar(PEliminar.get(i));
            }
            //Una vez hemos eliminado las referencias que tenia, podemos eliminarlo.           
            cc.Eliminar(cMod);

            //VEHICLES
            vc.Insertar(v1); // Insertem Vehicle
            Vehicle v2 = vc.Buscar(0L);
            v2.setMatricula("5451BXH");
            v2.setMarca("OPEL");
            v2.setAnyFabricacio("1996");
            v2.setClient(c1);
            vc.Modificar(v2);
            //Pasa lo mismo que en el apartado del cliente, que tiene referencias en otras tablas
            //por tanto, hay que eliminar las referencias.
            Polissa pEli = pc.buscarPolizaVehicle(0L);//Buscamos la poliza por vehiculo por su id.
            pc.Eliminar(pEli);
            //Ahora ya no tenemos referencias.
            vc.Eliminar(v2);

            //ASSEGURADORA
            ac.Insertar(a1);//Insertamos asseguradora
            Asseguradora aMod = ac.Buscar(0L);//Busquem asseguradora y la assignamos a la variable aMod.
            aMod.setNom("Asseguradora2");
            aMod.setNifcif("45215212E");
            ac.Modificar(aMod);//Confirmamos la modificacion en la BD.    
            ac.Eliminar(aMod);

            //POLISSES
            pc.Insertar(p1);
            Polissa pMod = pc.buscar(0L);
            pMod.setTipus(TipusPolissa.TOTRISC);//Modificamos el tipo de poliza
            pc.Modificar(pMod);
            pc.Eliminar(pMod);
            
            System.out.println("FIN");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
