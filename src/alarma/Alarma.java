 package alarma;

import alarma.Display.form;
import javax.swing.JOptionPane;
import alarma.reloj;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Alarma {
    JFrame fram =new JFrame();

    public static void main(String[] args) throws InterruptedException {
        reloj r =new reloj();// inicia el timer en el cosntructor
      
        form f = new form();
                f.setVisible(true);
        
    }
    
}

