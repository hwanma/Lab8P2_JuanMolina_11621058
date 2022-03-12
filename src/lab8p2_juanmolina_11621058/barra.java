/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2_juanmolina_11621058;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hwan
 */
public class barra extends Thread{
    Random r = new Random();
    private JProgressBar barra;
    private JTable tabla;
    ArrayList<carro> carros = new ArrayList();
    private int distancia;
    private boolean avanzar;
    private boolean vive;
    private Color color;
    
    public barra(JProgressBar barra,JTable tabla ,ArrayList<carro> carros ,int distancia) {
        this.barra = barra;
        this.tabla = tabla;
        this.carros = carros;
        this.distancia = distancia;
        avanzar=true;
        vive=true;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public ArrayList<carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<carro> carros) {
        this.carros = carros;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }


    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }


    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }
    
    @Override
    public void run(){
        while(vive){
            if(avanzar){
                distanciaCarros();
                barra.setValue(carros.get(0).getDistancia());
                barra.setBackground(carros.get(0).getColor());
                    if(barra.getValue()==distancia){
                        vive=false;
                    }
            } 
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public void distanciaCarros(){
        DefaultTableModel m = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < m.getRowCount(); i++) {
            m.removeRow(i);
        }
        
        carro temp = new carro();
        carro temp2 = new carro();
        for (carro carro1 : carros) {
            if(carro1.getTipo() == "McQueen"){
                carro1.setDistancia(30+r.nextInt(190));
            } else if(carro1.getTipo() == "Convertible"){
                carro1.setDistancia(20+r.nextInt(200));
            } else {
                carro1.setDistancia(40+r.nextInt(180));
            }
        }
        
        for ( int i = 0; i<carros.size() ;i++) {
            int index = i;
            for (int j = i+1 ;  i<carros.size() ; j++) {
                if(carros.get(j).getDistancia()<carros.get(index).getDistancia()){
                    index = j;
                }
            }
            temp = carros.get(index);
            temp2 = carros.get(i);
            carros.set(i,temp);
            carros.set(index,temp2);
        }
        
        for (carro carro1 : carros) {
            Object[] row ={carro1.getId(),carro1.getNombre(),carro1.getDistancia()};
            m.addRow(row);
        }
        tabla.setModel(m);
    }
}
