/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author exodus
 */
public class Prop {

    /**
     * Database User_name.
     */
    private String username;
    /**
     * Database password.
     */

    private String password;
    /**
     * Database host.
     */

    private String host;
    /**
     * Database name.
     */

    private String dbname;
    /**
     * Database port.
     */

    private String port;
    /**
     * AfricaTalk Username.
     */

    private String api_username;
    /**
     * AfricaTalk Api_key.
     */

    private String api_Key;
    /**
     * Daemon Number_of_threads
     */

    private Integer number_of_theads;
    /**
     * Daemon SleepTime.
     */
    private Integer sleepTime;

    /**
     * ConnectionTimeOut.
     */
    private Integer ConnectionTimeout;
    /**
     * Reply time Out.
     */

    private Integer ReplyTimeout;
    /**
     * DB BucketSize
     */

    private Integer BucketSize;
    /**
     * Application Name.
     */
    private String ApplicationName;

    static final Logger infoLog = Logger.getLogger("infoLog");
    static final Logger errorLog = Logger.getLogger("errorLog");
    static final Logger debugLog = Logger.getLogger("debugLog");
    static final Logger fatalLog = Logger.getLogger("fatalLog");

    Properties prop = new Properties();
    InputStream input;

    public Prop() {
        try {
            String filename = "conf/config.xml";
            input = Prop.class.getClassLoader().getResourceAsStream(filename);
            prop.loadFromXML(input);

            username = prop.getProperty("db_username");
            if (username.isEmpty()) {
                errorLog.error("Username not set");
            }
            password = prop.getProperty("db_password");
            if (password.isEmpty()) {
                errorLog.error("Password not set");
            }
            host = prop.getProperty("host");
            if (host.isEmpty()) {
                errorLog.error("Host not set");
            }
            dbname = prop.getProperty("db_name");
            if (dbname.isEmpty()) {
                errorLog.error("Database Name not set");
            }
            port = prop.getProperty("db_port");
            if (port.isEmpty()) {
                errorLog.error("Port not set");
            }
            api_username = prop.getProperty("api_username");
            if (api_username.isEmpty()) {
                errorLog.error("Africataling Api_Username not set");
            }
            api_Key = prop.getProperty("api_key");
            if (api_Key.isEmpty()) {
                errorLog.error("Africataling API_KEY not set");
            }
            number_of_theads = Integer.parseInt(prop.getProperty("NumberOfThreads"));
            if (number_of_theads == null) {
                errorLog.error("Number Of Threads not set");
            }

            sleepTime = Integer.parseInt(prop.getProperty("SleepTime"));
            if (sleepTime == null) {
                errorLog.error("Sleep time not set");
            }

            ConnectionTimeout = Integer.parseInt(prop.getProperty("ConnectionTimeout"));
            if (ConnectionTimeout == null) {
                errorLog.error("Connection timeout not set");
            }
            ReplyTimeout = Integer.parseInt(prop.getProperty("ReplyTimeout"));
            if (ReplyTimeout == null) {
                errorLog.error("ReplyTimeout not set");
            }
            BucketSize = Integer.parseInt(prop.getProperty("BucketSize"));
            if (BucketSize == null) {
                errorLog.error("BucketSize not set");
            }
            ApplicationName = prop.getProperty("ApplicationName");
            if (ApplicationName.isEmpty()) {
                errorLog.error("Application name not set");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            fatalLog.fatal("Exception" + ex.getMessage());
        }

    }

    //This method gets properties one by one 
    public String getProperty(String key) {
        try {
            if (input != null) {
                prop.loadFromXML(input);

                return prop.getProperty(key);
            } else {
                System.out.println("File not found");
                return "no file found";
            }
        } catch (IOException e) {
            return "";
        }

    }

    public String getApplicationName() {
        return ApplicationName;
    }

    public Integer getBucketSize() {
        return BucketSize;
    }

    public Integer getReplyTimeout() {
        return ReplyTimeout;
    }

    public Integer getConnectionTimeout() {
        return ConnectionTimeout;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getApi_username() {
        return api_username;
    }

    public void setApi_username(String api_username) {
        this.api_username = api_username;
    }

    public String getApi_Key() {
        return api_Key;
    }

    public void setApi_Key(String api_Key) {
        this.api_Key = api_Key;
    }

    public int getNumber_of_theads() {
        return number_of_theads;
    }

    public void setNumber_of_theads(int number_of_theads) {
        this.number_of_theads = number_of_theads;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

}
