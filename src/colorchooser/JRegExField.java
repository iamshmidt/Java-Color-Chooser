/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author nccmac
 */
public class JRegExField extends JTextField {
    private String exp;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
        setDocument(new RegExDocument(exp));
    }
    
    public JRegExField(){
        super();
    }

    public JRegExField(String exp) {
        this.exp = exp;
    }
    
    @Override
    protected Document createDefaultModel(){
        return new RegExDocument(exp);
    }
}
