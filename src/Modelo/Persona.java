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
     * 
     * @param CorreoElectronico 
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConcierto() {
        return concierto;
    }

    public void setConcierto(String concierto) {
        this.concierto = concierto;
    }

}
