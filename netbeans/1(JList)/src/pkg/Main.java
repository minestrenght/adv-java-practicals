package pkg;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Stationary");
        final float[] productPrices = {5.00f, 19.78f, 16.70f};
        final JList l = new JList(new String[]{"Pen", "Notes", "Marker"});
        Container c = f.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l);
        final JLabel lbl = new JLabel("Select any item");
        c.add(lbl);
        f.pack();
        f.setLocationRelativeTo(null);//position in d center
        f.setVisible(true);//show on d screen
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//kill app on close
        ListSelectionListener ll = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    float p = productPrices[l.getSelectedIndex()];
                    lbl.setText(String.format("Rs. %s/-", p));
                } catch (ArrayIndexOutOfBoundsException ex) {
                    lbl.setText("Select any item");
                }
            }
        };//<-- list selection handler
        l.addListSelectionListener(ll);//<-- attach handler
    }
}
