package alarma;

import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import alarma.Display.form;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class reloj {

    private int alamsec = 0;
    private int alammin = 0;
    private int alamhoras = 0;
    private int marca = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private boolean para=false;
    private boolean alarm=true;
    Timer timer;
    
    public reloj(){
        timer =new Timer();
            timer.schedule(new reloj.manillas(),1,1000); //cada segundo haga el run de manillas, y repite cada seg
            
    }
    
    public class manillas extends TimerTask{
            
        @Override
        public void run() {
                while(para!=true){
                    segundos++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(reloj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (horas == alamhoras&&minutos==alammin&&segundos == alamsec) {
                        form.alarma();
                    } 
                    else if (segundos >=59) {
                        minutos++;
                        segundos = 0;

                        if (horas == alamhoras&&minutos==alammin&&segundos == alamsec) {
                                form.alarma();
                        } 

                        else if (minutos >= 59) {
                            horas++;
                            minutos = 0;

                            if (horas == alamhoras&&minutos==alammin&&segundos == alamsec) {
                                form.alarma();
                            } 

                            else if (horas >= 23) {
                                horas=0;
                                break;
                            }
                }
            }
            else{
            }
                }
            throw new UnsupportedOperationException("El ususario paro el reloj"); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    public void enciendeAlarma(){
        String[] opciones={"encender alarma","apagar alarma"};

                   String op=(String)JOptionPane.showInputDialog(null,"Selecciona opcion:"," ",JOptionPane.PLAIN_MESSAGE,null,opciones,opciones);
                      switch(op){
                        case "apagar alarma":
                            alarm=false;
                            String msg="La alarma esta ahora apagada";
                            JOptionPane.showConfirmDialog(null,msg);        
                            break;
                        case "encender alarma":
                            alarm=true;
                            msg="La alarma esta encendida ahora";
                            JOptionPane.showConfirmDialog(null,msg);
                            break;
                      }
    }
    
    public void setAlarma(){
        
                
                            String msg="La alarma esta configurada para las:"+alamhoras+":"+alammin+":"+alamsec+" .\n Desea cambiarla?";
                            int resp=JOptionPane.showConfirmDialog(null,msg);
                            if(alarm==true){
                                    if(resp==0){
                                        alamsec = Integer.parseInt(JOptionPane.showInputDialog(null, "Segundos de la alarma"));
                                        alammin = Integer.parseInt(JOptionPane.showInputDialog(null, "minutos de la alarma"));
                                        alamhoras = Integer.parseInt(JOptionPane.showInputDialog(null, "hora de la alarma")); 
                                    }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"La alarma esta desactivada");
                            }
        
        }

    public int getAlamsec() {
        return alamsec;
    }

    public void setAlamsec(int alamsec) {
        this.alamsec = alamsec;
    }

    public int getAlammin() {
        return alammin;
    }

    public void setAlammin(int alammin) {
        this.alammin = alammin;
    }

    public int getAlamhoras() {
        return alamhoras;
    }

    public void setAlamhoras(int alamhoras) {
        this.alamhoras = alamhoras;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isPara() {
        return para;
    }

    public void setPara(boolean para) {
        this.para = para;
    }
    
}
