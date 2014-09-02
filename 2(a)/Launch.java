import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Launch {

    public static void main(String[] args) {
		JFrame f = new JFrame("Software Employees");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kill app on close
		Object[][] r = {
			{"Avinash", "Sharma", "Male", 19},
			{"Sana", "Munshi", "Female", 20},
			{"Nitesh", "Singh", "Male", 20},
			{"Anand", "Maurya", "Male", 19},
			{"Nikita", "Parab", "Female", 20},
			{"Madhvi", "Yadav", "Female", 20}
		};
		Object[] c = {
			"First Name", "Last Name", "Gender", "Age"
		};
		JTable t = new JTable(r, c);
		JScrollPane s = new JScrollPane(t);
		f.getContentPane().add(s);
		f.pack();
		f.setLocationRelativeTo(null);//position in d center
		f.setVisible(true);//show on d screen
    }
}
