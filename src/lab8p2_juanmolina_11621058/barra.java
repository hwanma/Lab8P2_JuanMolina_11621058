/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2_juanmolina_11621058;

import javax.swing.JProgressBar;

/**
 *
 * @author Hwan
 */
public class barra extends Thread{
    private JProgressBar barra;
    private int distancia;
    private boolean avanzar;
    private boolean vive;
    
    public barra(JProgressBar barra, int distancia) {
        this.barra = barra;
        this.distancia = distancia;
        avanzar=true;
        vive=true;
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
                barra.setValue(barra.getValue()+1);
                if(barra.getValue()==distancia){
                    vive=false;
                }                
            } //FIN IF
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
