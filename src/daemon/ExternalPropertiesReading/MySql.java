/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.ExternalPropertiesReading;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import org.apache.log4j.*;
import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;


/**
 *
 * @author exodus
 */
public class MySql extends ConfigfileReading{
    private static final Logger logger = Logger.getLogger(MySql.class);
    public static void main(String[] args) {
//     
//     ConfigfileReading cfg = new ConfigfileReading();
//   
//     String username =cfg.getProperty("db_username");
//     String pass = cfg.getProperty("db_password");
//     String database =cfg.getProperty("db");
//     String api_username = cfg.getProperty("api_username");
//     String api_key = cfg.getProperty("api_key");
//     System.out.print(username+" "+pass+" "+database+" "+api_username+" "+api_key);
//     
//    try {  
//       Class.forName("com.mysql.jdbc.Driver");
//       String connectionUrl = "jdbc:mysql://localhost/"+database+"?" + 
//                              "user="+username+"&password="+pass;
//       //Logging
//       logger.info("Creating a Msql Connection");
//       Connection con = DriverManager.getConnection(connectionUrl);
//
//       //Logging
//       logger.info("Creating a Msql Query");
//       String sql = "SELECT * FROM outboundSMS WHERE status = 0";
//
//       //Logging
//       logger.info("Executing Query");
//       Statement statement = con.createStatement();
//       ResultSet result = statement.executeQuery(sql);
//       
//        //Reading Records
//         while (result.next()){
//            String msisdn = result.getString("MSISDN");
//            String message = result.getString("message");
//
//            // Initialize
//            String api_u = "tele10_i-pesa";    // use 'sandbox' for development in the test environment
//            String apiKey = "3c9360e39a2baba4acb50233ed081006a8954b07962487442819035c881b4195";       // use your sandbox app API key for development in the test environment
//            AfricasTalking.initialize(api_u, apiKey);
//
//            // Initialize a service e.g. SMS
//            SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
//            String [] numbers ={msisdn};
//            
//            try {
//                // Sending SMSs
//               List<Recipient> response = sms.send(message, numbers, true);
//            } catch (IOException ex) {
//                java.util.logging.Logger.getLogger(MySql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
//
//             
//         }
//         
//         // Updating SMS status
//         String sql_update = "UPDATE outboundSMS SET status = 1";
//         PreparedStatement statement_update = con.prepareStatement(sql_update);
//         statement_update.executeUpdate();
//         
//         con.close();
//
//    } catch (SQLException e) {
//        System.out.println("SQL Exception: "+ e.toString());
//        logger.fatal("Sql Exception occured");
//    } catch (ClassNotFoundException cE) {
//        logger.fatal("Sql Class not Found");
//        System.out.println("Class Not Found Exception: "+ cE.toString());
//    }        

 
    

    }
}
