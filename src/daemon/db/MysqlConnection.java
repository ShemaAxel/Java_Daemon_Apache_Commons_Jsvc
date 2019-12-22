/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.db;

import daemon.util.Prop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author exodus
 */
public class MysqlConnection {

    private Connection con;
    private String connectionUrl;
    Prop prop = new Prop();

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectionUrl = "jdbc:mysql://" + prop.getHost() + "/" + prop.getDbname() + "?"
                    + "user=" + prop.getUsername() + "&password=" + prop.getPassword();
            

            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
           
        } catch (ClassNotFoundException cE) {
           
            System.out.println("Class Not Found Exception: " + cE.toString());
        }

        return con;
    }

}
