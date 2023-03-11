/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandro Penagos
 */
public class Persona {
    
    private String nombre;
    private String CorreoElectronico;
    private String cedula;
    private String telefono;
    private String concierto;
    
    /**
     * Devuelve el nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
     
    /**
     * Cambia el atributo nombre del objeto
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el CorreoElectronico
     * @return CorreoElectronico
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }
    
    /**
     * Cambia el atributo CorreoElectronico del objeto
     * @param CorreoElectronico 
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    /**
     * Devuelve la Cedula
     * @return Cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Cmabia el atributo Cedula del objeto 
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Devuleve el Telefono
     * @return Telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Cambia el atributo Telefono del objeto
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el Concierto
     * @return Concierto
     */
    public String getConcierto() {
        return concierto;
    }

    /**
     * Cambia el atributo Concierto del objeto
     * @param concierto 
     */
    public void setConcierto(String concierto) {
        this.concierto = concierto;
    }

}
