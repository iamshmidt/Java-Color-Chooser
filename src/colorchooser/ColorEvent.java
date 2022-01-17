/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import java.awt.Color;
import java.util.EventObject;

/**
 *
 * @author nccmac
 */
public class ColorEvent extends EventObject {

    private Color color;

    public ColorEvent(Object source, Color color) {
        super(source);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
