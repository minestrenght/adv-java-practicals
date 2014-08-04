import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Launch {

    public static void main(String[] args) {
		JFrame f = new JFrame("Stationary");
		String[] productNames = {"Lexi Pen", "Navneet Short Book", "Ruler"};
		final float[] productPrices = {5.00f, 19.78f, 16.70f};
		final JList<String> l = new JList<String>(productNames);
		Container c = f.getContentPane();
		c.add(l);
        final String defaultText = "Select 1";
		final JTextField tf = new JTextField(defaultText);
		tf.setEditable(false);//<-- disable
		c.add(tf, BorderLayout.SOUTH);
		f.pack();
		f.setLocationRelativeTo(null);//position in d center
		f.setVisible(true);//show on d screen
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kill app on close

		ListSelectionListener ll = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    return;
                }
                String txt = defaultText;
                try {
                    float p = productPrices[l.getSelectedIndex()];
                    txt = String.format("Rs. %s/-", p);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.err.println("Nothing was selected ...");
                }
				tf.setText(txt);
			}
		};//<-- list selection handler

		l.addListSelectionListener(ll);//<-- attach handler
    }
}
