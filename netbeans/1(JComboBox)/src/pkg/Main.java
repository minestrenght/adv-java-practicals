package pkg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Stationary");
        final float[] productPrices = {5.00f, 19.78f, 16.70f};
        final JComboBox cb = new JComboBox(new String[]{"Select", "Pen", "Notes", "Marker"});
        Container c = f.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(cb);
        final JLabel lbl = new JLabel("Select any item");
        c.add(lbl);
        f.pack();
        f.setLocationRelativeTo(null);//position in d center
        f.setVisible(true);//show on d screen
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//kill app on close
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    float p = productPrices[cb.getSelectedIndex() - 1];
                    lbl.setText(String.format("Rs. %s/-", p));
                } catch (ArrayIndexOutOfBoundsException ex) {
                    lbl.setText("Select any item");
                }
            }
        };//<-- list selection handler
        cb.addItemListener(il);//<-- attach handler
    }
}
