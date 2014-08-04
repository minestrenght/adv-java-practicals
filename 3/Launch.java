import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.net.URL;

public class Launch {

    public static void main(String[] args) {
		final JFrame f = new JFrame("Planets");
		String[] names = {"Earth", "Moon", "Sun", "Mars"};
		final JList<String> list = new JList<String>(names);
        final String text = "Select planet to the left";
		final JLabel lbl = new JLabel(text);
		f.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, lbl));
		f.pack();
		f.setLocationRelativeTo(null);//position in d center
		f.setVisible(true);//show on d screen
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kill app on close

        final ImageIcon[] icons = new ImageIcon[names.length];
		ListSelectionListener ll = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    return;
                }
                ImageIcon icon = null;
                String str = text;
                try {
                    icon = icons[list.getSelectedIndex()];
                    str = "";//<-- remove default text
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.err.println("Nothing was selected !");
                }
                lbl.setIcon(icon);//<-- set planet icon
                lbl.setText(str);//<-- set label text
                f.pack();//<-- resize frame as per new icon size and label
			}
		};//<-- list selection handler

		list.addListSelectionListener(ll);//<-- attach handler
        int  i = 0;
        ClassLoader cl = Launch.class.getClassLoader();
        URL url;
        for(String p : names) {//<-- creating planet image icons to show
            url = cl.getResource(p.toLowerCase() + ".jpg");
            icons[i ++] = new ImageIcon(url);
        }
    }
}
