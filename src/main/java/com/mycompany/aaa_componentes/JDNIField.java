package com.mycompany.aaa_componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class JDNIField extends JTextField implements Serializable, FocusListener{
    public JDNIField() {
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setForeground(Color.black);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(!validateDNI(getText())) {
            setForeground(Color.red);   
        }
        else {            
            setForeground(Color.green); 
        }
    }
    
    public static final String DNI_CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    public static boolean validateDNI(String dniStr) {
          String dniSaneado = dniStr.trim().replaceAll(" ", "").replaceAll("-", "");
          
          String numerosDNI = dniSaneado.substring(0,dniSaneado.length()-1);
          String letraDNI = dniSaneado.substring(dniSaneado.length()-1, dniSaneado.length());
          
          int numDNI = Integer.parseInt(numerosDNI);
          int i = numDNI%23;
          String l = DNI_CHARS.substring(i,i+1);
          
          if (letraDNI.equals(l)) {
              return true;
          }
          
          
          return false;
          
//        String lookup_patter = "(\\d{1,8})([" + DNI_CHARS + DNI_CHARS.toLowerCase() + "])";
//        System.out.println("BUSCANDO" + lookup_patter + " en " + dniStr);
//        Pattern patron = Pattern.compile(lookup_patter); 
//        Matcher matcher = patron.matcher(dniStr);
//        
//        int dni = Integer.parseInt(matcher.group(1));
//        String letra = matcher.group(2);
//        String letraEsperada = DNI_CHARS.substring(dni%23, (dni%23) + 1);
//        
//        if (letraEsperada.equalsIgnoreCase(letra)) {
//            return true;
//        }
//       return false;
        
    }
    
       
    
}
