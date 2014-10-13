package pkg;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Software Employees");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kill app on close
        Object[][] r = {
            {"Avinash", "Sharma", "Developer", 19},
            {"Sana", "Munshi", "Tester", 20},
            {"Nitesh", "Singh", "Developer", 20},
            {"Anand", "Maurya", "Developer", 19},
            {"Nikita", "Parab", "Tester", 20},
            {"Madhvi", "Yadav", "Tester", 20}
        };
        Object[] c = {
            "First Name", "Last Name", "Position", "Age"
        };
        f.getContentPane().add(new JScrollPane(new JTable(r, c)));
        f.pack();
        f.setLocationRelativeTo(null);//position in d center
        f.setVisible(true);//show on d screen
    }
}
