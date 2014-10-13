/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author sharma
 */
@ManagedBean
@RequestScoped
public class inventory {

    private String name;
    private int price;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    public String add() {
        String redirect = "fail";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
            PreparedStatement ps = con.prepareStatement("insert into tablename values ?,?");
            ps.setString(1,name);
            ps.setInt(2, price);
            if(0>ps.executeUpdate())
            {redirect="success";
            ps.close();
            con.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return redirect;
    }

}
