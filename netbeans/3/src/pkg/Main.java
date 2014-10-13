package pkg;

import javax.swing.*;
import javax.swing.event.*;

public class Main {

    public static void main(String[] args) {
        final JFrame f = new JFrame("Planets");
        final JList list = new JList(new String[]{
            "Earth", "Moon", "Sun", "Mars"});
        final JLabel lbl = new JLabel("Select planet to the left");
        f.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, lbl));
        f.pack();
        f.setLocationRelativeTo(null);//position in d center
        f.setVisible(true);//show on d screen
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//kill app on close
        ListSelectionListener ll = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String path = "/pkg/" + list.getSelectedValue().toString().toLowerCase() + ".jpg";
                    lbl.setIcon(new ImageIcon(getClass().getResource(path)));
                    lbl.setText("");
                } catch (Exception ex) {
                    lbl.setIcon(null);
                    lbl.setText("Select one planet");
                }
                f.pack();//<-- resize frame as per new icon size and label
            }
        };//<-- list selection handler
        list.addListSelectionListener(ll);//<-- attach handler
    }
}
 