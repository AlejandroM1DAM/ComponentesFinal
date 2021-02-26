/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aaa_componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.validator.routines.CreditCardValidator;

/**
 *
 * @author Alejandro
 */
public class JCCValidatorFiel  extends JPanel implements Serializable, FocusListener{
    public JCCValidatorFiel() {
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setForeground(Color.black);
    }

    @Override
    public void focusLost(FocusEvent e) {
         if(!validarTarjetaCredito(getText())) {
            setForeground(Color.red);   
        }
        else {            
            setForeground(Color.green); 
        }
    } 
    private boolean validarTarjetaCredito(String ccStr) {
            CreditCardValidator ccv = new CreditCardValidator();    
            return ccv.isValid(ccStr);
            
    }

    private String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
