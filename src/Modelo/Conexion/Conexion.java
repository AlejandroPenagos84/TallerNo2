/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Conexion;

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
     * Rellena de espacios o corta el String según sea el caso.
     *
     * @param m String
     * @param num Número máximo de caracteres
     * @return
     */
    public String ValidarString(String m, int num) {
        if (m.length() < num) {
            for (int i = m.length(); i < num; i++) {
                m += " ";
            }
        } else {
            m = m.substring(0, num);
        }
        return m;
    }

    /**
     * Crea un String con caracteres dentro de una ArrayList
     *
     * @param letras Lista de letras de un String
     * @return newString
     */
    public StringBuilder ValidarListas(ArrayList<Character> letras) {
        StringBuilder newString = new StringBuilder(letras.size());
        for (Character ch : letras) {
            newString.append(ch);
        }
        return newString;
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
    public void Escribir(String cedula, String nombre, String correoElectronico, String telefono, int numBoletas, String concierto) {
        try {
            ArrayList<Character> letrasCorreo = new ArrayList();
            ArrayList<Character> letrasServidor = new ArrayList();
            int k = -1;

            for (int i = 0; i < correoElectronico.length(); i++) {
                char c = correoElectronico.charAt(i);
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

            String correo = this.ValidarListas(letrasCorreo).toString();
            String servidor = this.ValidarListas(letrasServidor).toString();

            String cedulaArch = this.ValidarString(cedula, 10);
            String nombreArch = this.ValidarString(nombre, 50);
            String correoArch = this.ValidarString(correo, 20);
            String servidorArch = this.ValidarString(servidor, 7);
            String telefonoArch = this.ValidarString(telefono, 10);
            String conciertoArch = this.ValidarString(concierto, 17);

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
            fl.writeInt(numBoletas);
            
        } catch (FileNotFoundException f) {
        } catch (IOException ioe) {
        }

    }
}
