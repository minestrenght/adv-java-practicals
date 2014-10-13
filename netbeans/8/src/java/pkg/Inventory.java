package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Inventory {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String add() {
        String redirect = "failure";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minestrenght", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into inventory values(?,?)");
            ps.setString(1, name);
            ps.setInt(2, price);
            if (0 < ps.executeUpdate()) {
                redirect = "success";
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return redirect;
    }
}
