import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Launch {

    public static void main(String[] args) {
		JFrame f = new JFrame("Stationary");
		String[] planetNames = {"Earth", "Moon", "Sun"};
		final JList<String> list = new JList<String>(planetNames);
		final JLabel lbl = new JLabel("Select planet to the left");
		f.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, lbl));
		f.pack();
		f.setLocationRelativeTo(null);//position in d center
		f.setVisible(true);//show on d screen
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kill app on close

		ListSelectionListener ll = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//
			}
		};//<-- list selection handler

		list.addListSelectionListener(ll);//<-- attach handler
    }
}
