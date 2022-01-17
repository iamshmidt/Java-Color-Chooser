/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

/**
 *
 * @author nccmac
 */
public class JIntegerField extends JRegExField {
    public JIntegerField(){
        super();
//        setExp("^[0-9]*$");
//        \b([1-9]|10)\b
        setExp("^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$");
    }
}
