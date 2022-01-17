/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

//import java.awt.Color;
//import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//import javax.swing.SwingUtilities;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import colorchooser.ColorIntTextField;

/**
 *
 * @author yulii
 */
public class ColorTextField extends javax.swing.JPanel implements ColorListener {

    private ArrayList listeners;

    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
            update();
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            update();
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            update();
        }

        protected void update() {
            int r = 0;
            int g = 0;
            int b = 0;
            if ((redInput.getText()).length() > 0) {
                r = Integer.parseInt(redInput.getText());
            }
            if ((greenInput.getText()).length() > 0) {
                g = Integer.parseInt(greenInput.getText());
            }
            if ((blueInput.getText()).length() > 0) {
                 b = Integer.parseInt(blueInput.getText());
            }
            Color color = new Color(r, g, b);
            fireColorEvent(new ColorEvent(this, color));
        }
    };

    /**
     * Creates new form ColorTextField
     */
    public ColorTextField() {
        initComponents();
        listeners = new ArrayList();
        redInput.addKeyListener(kl);
        greenInput.addKeyListener(kl);
        blueInput.addKeyListener(kl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redLabel = new javax.swing.JLabel();
        greenLabel = new javax.swing.JLabel();
        blueLabel = new javax.swing.JLabel();
        redInput = new colorchooser.JIntegerField();
        greenInput = new colorchooser.JIntegerField();
        blueInput = new colorchooser.JIntegerField();

        redLabel.setText("Red");

        greenLabel.setText("Green");

        blueLabel.setText("Blue");

        redInput.setColumns(3);
        redInput.setText("0");

        greenInput.setColumns(3);
        greenInput.setText("0");

        blueInput.setColumns(3);
        blueInput.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greenLabel)
                    .addComponent(blueLabel)
                    .addComponent(redLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redLabel)
                    .addComponent(redInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenLabel)
                    .addComponent(greenInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blueLabel)
                    .addComponent(blueInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private colorchooser.JIntegerField blueInput;
    private javax.swing.JLabel blueLabel;
    private colorchooser.JIntegerField greenInput;
    private javax.swing.JLabel greenLabel;
    private colorchooser.JIntegerField redInput;
    private javax.swing.JLabel redLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void changeColor(ColorEvent ce) {
        redInput.setText(String.valueOf(ce.getColor().getRed()));
        greenInput.setText(String.valueOf(ce.getColor().getGreen()));
        blueInput.setText(String.valueOf(ce.getColor().getBlue()));
    }

    private void fireColorEvent(ColorEvent ce) {
        ArrayList copy;
        synchronized (listeners) {
            copy = (ArrayList) listeners.clone();
        }
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            ColorListener colorListener = (ColorListener) copy.get(i);
            colorListener.changeColor(ce);
        }
    }
    
    public void addInputListener(ColorListener colorListener) {
        listeners.add(colorListener);
    }

}
