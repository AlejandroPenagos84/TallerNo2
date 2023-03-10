/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandro Penagos
 */
public class VIP extends Persona{
    private int numBoletas;
    
    /**
     * Devuelve el número de boletas
     * @return número de boletas
     */
    public int getNumBoletas() {
        return numBoletas;
    }
    
    /**
     * Permite modificar el número de boletas
     * @param numBoletas Nuevo número de boletas
     */
    public void setNumBoletas(int numBoletas) {
        this.numBoletas = numBoletas;
    }
    
    
}
