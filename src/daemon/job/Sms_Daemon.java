/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.job;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import daemon.ExternalPropertiesReading.MySql;
import daemon.MyDaemon;
import daemon.db.MysqlConnection;
import daemon.util.Prop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;

/**
 *
 * @author exodus
 */
public class Sms_Daemon extends MyDaemon {

    static final Logger infoLog = Logger.getLogger("infoLog");
    static final Logger errorLog = Logger.getLogger("errorLog");
    static final Logger debugLog = Logger.getLogger("debugLog");
    static final Logger fatalLog = Logger.getLogger("fatalLog");
    Prop prop = new Prop();
    MysqlConnection connection = new MysqlConnection();
    Connection con;

    public Sms_Daemon() {
        super();
        con = connection.getConnection();
    }

    //Define the daemon task
    @Override
    public void daemon_Task() {

        infoLog.info("Sms Daemon Started");
        try {

            //Logging
            infoLog.info("Searching for unsent SMSs");
            String sql = "SELECT * FROM outboundSMS WHERE status = 0";

            //Logging
            infoLog.info("Executing Query");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            //Reading Records
            // Initialize
            AfricasTalking.initialize(prop.getApi_username(), prop.getApi_Key());
            // Initialize a service e.g. SMS
            //Logging
            infoLog.info("Initialize a service e.g. SMS");
            SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);

            while (result.next()) {
                String msisdn = result.getString("MSISDN");
                String message = result.getString("message");
                int id = result.getInt("outboundSMSID");

                String[] numbers = {msisdn};

                // Sending SMSs
                //Logging
                infoLog.info("Sending SMSs");

                // List<Recipient> response = sms.send(message, numbers, true);
                List myList = new ArrayList();// hardcoded

                List<Recipient> response = sms.send(message, numbers, true);

                // Updating SMS status
                //Logging
                infoLog.info("Updating SMSs statuses");
                String sql_update = "UPDATE outboundSMS SET status = 1 WHERE outboundSMSID=? limit ?";
                PreparedStatement statement_update = con.prepareStatement(sql_update);
                statement_update.setInt(1, id);
                statement_update.setInt(2, prop.getBucketSize());
                statement_update.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
            fatalLog.fatal("Sql Exception occured" + e.toString());
        } catch (IOException ex) {
            fatalLog.fatal("IOException occured" + ex.toString());
            java.util.logging.Logger.getLogger(Sms_Daemon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

}
