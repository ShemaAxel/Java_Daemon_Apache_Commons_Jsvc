/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import daemon.ExternalPropertiesReading.ConfigfileReading;
import daemon.ExternalPropertiesReading.MySql;
import daemon.util.Prop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;

/**
 *
 * @author exodus
 */
public class MyDaemon implements Daemon {

    static final Logger infoLog = Logger.getLogger("infoLog");
    static final Logger errorLog = Logger.getLogger("errorLog");
    static final Logger debugLog = Logger.getLogger("debugLog");
    static final Logger fatalLog = Logger.getLogger("fatalLog");
    
    private Thread myThread;
    private boolean stopped = false;
    // private boolean lastOneWasATick = false;
    Prop prop = new Prop();

    @Override
    public void init(DaemonContext context) throws DaemonInitException, Exception {
        /*
    * Construct objects and initialize variables here.
    * You can access the command line arguments that would normally be passed to your main()
    * method as follows:
         */
        String[] args = context.getArguments();
        myThread = new Thread() {
            private long lastTick = 0;

            @Override
            public synchronized void start() {
                MyDaemon.this.stopped = false;
                super.start();
            }

            @Override
            public void run() {

                while (!stopped) {
                    //task calling
                    infoLog.fatal("Main Daemon Started in Main");
                    //Calling the task method
                    daemon_Task();
                    infoLog.fatal("Task Ends ...");
                    try {
                        Thread.sleep(prop.getSleepTime());
                    } catch (InterruptedException ex) {
                        fatalLog.fatal("Exception occured" + ex.getMessage());
                        java.util.logging.Logger.getLogger(MyDaemon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }

            }
        };
    }

    @Override
    public void start() throws Exception {
        myThread.start();
    }

    @Override
    public void stop() throws Exception {
        stopped = true;
        try {
            myThread.join(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void destroy() {
        myThread = null;
    }

    public void daemon_Task() {
        System.out.println("Testing from main Class");
    }

}
