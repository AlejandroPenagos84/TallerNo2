/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion.Conexion;
import Modelo.VIP;
import Vista.Menu;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alejandro Penagos
 */
public class Control implements ActionListener {

    //Declaracion de variables//
    private VIP comprador;
    private ArrayList<VIP> listaCompradores;
    private Venta vista;
    private Menu menu;
    private Conexion conexion;

    public Control() {

        //Instancia de objetos//
        vista = new Venta();
        menu = new Menu();
        listaCompradores = new ArrayList();

        //Declaracion de los botones//
        this.vista.btnComprar.addActionListener(this);
        this.menu.btnComprarBoleta.addActionListener(this);;
        this.menu.btnFinalizarPreventa.addActionListener(this);
        this.menu.btnArchivo.addActionListener(this);
        this.vista.btnDevolverseAlMenu.addActionListener(this);
        this.menu.btnSalir.addActionListener(this);
        this.iniciarMenu(true);
    }

    /**
     * Crea un comprador y lo agrega en una lista
     *
     * @param cedula Cedula de la persona
     * @param nombre Nombre de la persona
     * @param CorreoElectronico Correo electrónico de la persona
     * @param telefono Télefono de la persona
     * @param numBoletas Número de boletas de la persona
     * @param concierto Concierto que eligio la persona
     */
    public void AgregarPersona(String cedula, String nombre, String CorreoElectronico, String telefono, int numBoletas, String concierto) {
        boolean estadoCedula = false;
        boolean estadoCorreo = false;
        boolean estadoTelefono = false;

        Iterator<VIP> it = listaCompradores.iterator();
        VIP aux;

        while (it.hasNext()) {
            aux = (VIP) it.next();

            if (aux.getCedula().equals(cedula)) {
                estadoCedula = true;
            }

            if (aux.getCorreoElectronico().equals(CorreoElectronico)) {
                estadoCorreo = true;
            }

            if (aux.getTelefono().equals(telefono)) {
                estadoTelefono = true;
            }
        }

        if (estadoCedula) {
            vista.MostrarMensaje("La cedula ya se encuentra regustrada");
            this.iniciarVista(true);
            this.iniciarMenu(false);
        } else if (estadoCorreo) {
            vista.MostrarMensaje("El correo ya se encuentra registrado");
            this.iniciarVista(true);
            this.iniciarMenu(false);
        } else if (estadoTelefono) {
            vista.MostrarMensaje("El telefono ya se encuentra registrado");
            this.iniciarVista(true);
            this.iniciarMenu(false);
        } else {
            comprador = new VIP();
            comprador.setCedula(cedula);
            comprador.setNombre(nombre);
            comprador.setCorreoElectronico(CorreoElectronico);
            comprador.setTelefono(telefono);
            comprador.setNumBoletas(numBoletas);
            comprador.setConcierto(concierto);

            listaCompradores.add(comprador);
            vista.MostrarMensaje("Venta Exitosa");

            this.iniciarVista(false);
            this.iniciarMenu(true);
        }
    }

    /**
     * Metodo que genera la ventana donde se guardan los datos, y la centra en
     * la pantalla
     *
     * @param estado Indica si la interfaz es visible o no
     *
     */
    public void iniciarVista(boolean estado) {
        this.vista.setTitle("Compradores");
        //Se le indica la posicion --> null para que la ventana inicie en la posicion 0 es decir en el centro de la pantalla
        vista.setVisible(estado);
        this.vista.setLocationRelativeTo(null);
    }

    /**
     * Metodo que genera la ventana del menu, y la centra en la pantalla
     *
     * @param estado Indica si el menu es visile o no
     *
     */
    public void iniciarMenu(boolean estado) {
        this.menu.setTitle("Compradores");
        //Se le indica la posicion --> null para que la ventana inicie en la posicion 0 es decir en el centro de la pantalla
        menu.setVisible(estado);
        this.menu.setLocationRelativeTo(null);
    }

    /**
     * Valida de el el mensaje tenga solo números
     *
     * @param m Mensaje
     * @return
     */
    public boolean ValidarNumeros(String m) {
        boolean estado = true;
        for (int i = 0; i < m.length(); i++) {
            if (!Character.isDigit(m.charAt(i))) {
                estado = false;
            }
        }
        return estado;
    }

    /**
     * Valida de que el String tenga solo letras
     *
     * @param m Mensaje
     * @return
     */
    public boolean ValidarLetras(String m) {
        boolean estado = true;
        for (int i = 0; i < m.length(); i++) {
            if ((!Character.isAlphabetic(m.charAt(i))) && (m.charAt(i) != ' ')) {
                estado = false;
                break;
            }
        }
        return estado;
    }

    /**
     * Valida del que el correo que '@'
     *
     * @param m Mensaje
     * @return
     */
    public boolean ValidarCorreo(String m) {
        boolean estado = false;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == '@') {
                estado = true;
            }
        }
        return estado;
    }

    /**
     * Valida que el mensaje tenga espacios
     *
     * @param m Mensaje
     * @return
     */
    public boolean ValidarEspacios(String m) {
        boolean estado = false;
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == ' ') {
                estado = true;
            }
        }
        return estado;
    }

    /**
     * Rellena de espacios o corta el String según sea el caso.
     *
     * @param m String
     * @param num Número máximo de caracteres
     * @return
     */
    public String RellenarYValidarString(String m, int num) {
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
    public StringBuilder ConvertirListasAString(ArrayList<Character> letras) {
        StringBuilder newString = new StringBuilder(letras.size());
        for (Character ch : letras) {
            newString.append(ch);
        }
        return newString;
    }

    @Override
    /**
     * Sobreescritura de los botones de la vista
     *
     * @param ActionEvente Libreria sobreescribir la funcion de cada boton
     *
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menu.btnComprarBoleta) {
            this.iniciarVista(true);
            this.iniciarMenu(false);
        }

        try {
            if (e.getSource() == this.menu.btnArchivo) {
                conexion = new Conexion(this.menu.getFile());
            }
        } catch (NullPointerException o) {
        }

        if (e.getSource() == vista.btnDevolverseAlMenu) {
            this.iniciarMenu(true);
            this.iniciarVista(false);
        }

        if (e.getSource() == menu.btnSalir) {
            menu.dispose();
            vista.dispose();
        }

        if (e.getSource() == this.menu.btnFinalizarPreventa) {
            if (this.conexion == null) {
                vista.MostrarMensaje("Debes seleccionar un archivo");
            } else {
                for (int i = 0; i < listaCompradores.size(); i++) {
                    this.conexion.RegistrarCompradores(listaCompradores.get(i), this);
                }
                this.menu.MostrarPorConsola("El número de personas registradas es: " + conexion.numRegistros());
                this.conexion.cerrar();
                this.vista.dispose();
                this.menu.dispose();
            }
        }

        if (e.getSource() == this.vista.btnComprar) {
            if ((this.vista.txtCedula.getText().isEmpty())
                    || (this.vista.txtNombre.getText().isEmpty())
                    || (this.vista.txtCorreoElectronico.getText().isEmpty())
                    || (this.vista.txtTelefono.getText().isEmpty())
                    || (this.vista.txtNumBoletas.getText().isEmpty())
                    || (this.vista.jBoxConcierto.getSelectedItem().equals(null))) {
                vista.MostrarMensaje("Debes rellenar todos los campos");

            } else if (!this.ValidarNumeros(this.vista.txtCedula.getText())) {
                if (this.ValidarEspacios(this.vista.txtCedula.getText())) {
                    vista.MostrarMensaje("La cedula no puede llevar espacios");
                } else {
                    vista.MostrarMensaje("La cedula solo se pueden ingresar datos númericos");
                }
            } else if (!this.ValidarNumeros(this.vista.txtTelefono.getText())) {
                if (this.ValidarEspacios(this.vista.txtTelefono.getText())) {
                    vista.MostrarMensaje("El telefon no puede llevar espacios");
                } else {
                    vista.MostrarMensaje("Solo datos númericos pueden ir en el telofono");
                }
            } else if (!this.ValidarNumeros(this.vista.txtNumBoletas.getText())) {
                if (this.ValidarEspacios(this.vista.txtNumBoletas.getText())) {
                    vista.MostrarMensaje("El número de boleta no puede llevar espacios");
                } else {
                    vista.MostrarMensaje("Solo datos númericos para el número de boletas");
                }
            } else if (!this.ValidarLetras(this.vista.txtNombre.getText())) {
                System.out.print(this.ValidarLetras(this.vista.txtNombre.getText()));
                vista.MostrarMensaje("No puedes agregar números en el nombre");
            } else if (!this.ValidarCorreo(this.vista.txtCorreoElectronico.getText())) {
                if (this.ValidarEspacios(this.vista.txtCorreoElectronico.getText())) {
                    vista.MostrarMensaje("El correo no puede llevar espacios");
                } else {
                    vista.MostrarMensaje("Ingresa un correo valido");
                }

            } else {
                this.AgregarPersona(
                        this.vista.txtCedula.getText(), this.vista.txtNombre.getText(),
                        this.vista.txtCorreoElectronico.getText(),
                        this.vista.txtTelefono.getText(),
                        Integer.parseInt(this.vista.txtNumBoletas.getText()),
                        (String) this.vista.jBoxConcierto.getSelectedItem()
                );

                this.vista.Blanquear();

            }
        }

    }
}
