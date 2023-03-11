/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Conexion;

import Controlador.Control;
import Modelo.VIP;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Penagos
 */
public class Conexion {

    private File archivo;
    //private FileInputStream f1;//Archivo que va a coger
    //private InputStreamReader f2;//Que va a circular
    private RandomAccessFile fl;
    private long tamreg;
    private long canreg;
    // private Control control;

    /**
     * Constructor
     *
     * @param arch Archivo .dat
     */
    public Conexion(File arch) {
        this.tamreg = 232;
        this.canreg = 0;

        try {
            this.archivo = arch;
            fl = new RandomAccessFile(archivo, "rw");
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * Cuenta cuantas personas se encuentras registradas
     *
     * @return cantReg Cantidad de Registros
     */
    public long numRegistros() {
        try {
            this.canreg = this.fl.length() / this.tamreg;
        } catch (IOException ioe) {
        }
        return this.canreg;
    }

    /**
     *Se encarga de cerrar el RandomAccessFile
     **/
    public void cerrar() {
        try {
            fl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        /**
         * Escribe un registro dentro del archivo .dat
         *
         * @param cedula Cedula de la persona
         * @param nombre Nombre Completo de la persona
         * @param correoElectronico Correo Electrónico de la persona
         * @param telefono Teléfono de la persona
         * @param numBoletas Número de boletas que va a comprar
         * @param concierto Concierto al que quiere ir la persona
         */
    public void RegistrarCompradores(VIP comprador, Control con) {
        try {
            ArrayList<Character> letrasCorreo = new ArrayList();
            ArrayList<Character> letrasServidor = new ArrayList();
            int k = -1;

            for (int i = 0; i < comprador.getCorreoElectronico().length(); i++) {
                char c = comprador.getCorreoElectronico().charAt(i);
                if (c != '@') {
                    if (k == -1) { // Todavía no se ha encontrado la '@'
                        letrasCorreo.add(c);
                    } else { // Se ha encontrado la '@'
                        letrasServidor.add(c);
                    }
                } else { // Se ha encontrado la '@'
                    letrasServidor.add(c);
                    k = i;
                }

            }

            String correo = con.ConvertirListasAString(letrasCorreo).toString();
            String servidor = con.ConvertirListasAString(letrasServidor).toString();

            String cedulaArch = con.RellenarYValidarString(comprador.getCedula(), 10);
            String nombreArch = con.RellenarYValidarString(comprador.getNombre(), 50);
            String correoArch = con.RellenarYValidarString(correo, 20);
            String servidorArch = con.RellenarYValidarString(servidor, 7);
            String telefonoArch = con.RellenarYValidarString(comprador.getTelefono(), 10);
            String conciertoArch = con.RellenarYValidarString(comprador.getConcierto(), 17);

            /////////////////////////////////////////////////////////
            /* 
           System.out.println("########################################");
           System.out.println("#"+cedulaArch+"#");
           System.out.println("#"+nombreArch+"#");
           System.out.println("#"+correoArch+"#");
           System.out.println("#"+servidorArch+"#");
           System.out.println("#"+telefonoArch+"#");
           System.out.println("#"+conciertoArch +"#");
           System.out.println("#"+numBoletas +"#");
           System.out.println("########################################");
           System.out.println("");
             */
            fl.seek(fl.length());
            fl.writeChars(cedulaArch);
            fl.writeChars(nombreArch);
            fl.writeChars(correoArch);
            fl.writeChars(servidorArch);
            fl.writeChars(telefonoArch);
            fl.writeChars(conciertoArch);
            fl.writeInt(comprador.getNumBoletas());
            
        } catch (FileNotFoundException f) {
        } catch (IOException ioe) {
        }

    }
}
