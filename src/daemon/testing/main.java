/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.testing;

import daemon.ExternalPropertiesReading.MySql;
import org.apache.log4j.Logger;

/**
 *
 * @author exodus
 */
public class main {

    static final Logger infoLog = Logger.getLogger("infoLog");
    static final Logger errorLog = Logger.getLogger("errorLog");
    static final Logger debugLog = Logger.getLogger("debugLog");
    static final Logger fatalLog = Logger.getLogger("fatalLog");

    public static void main(String[] args) {
        infoLog.info("info");
        errorLog.error("error");
        debugLog.debug("debug");
        fatalLog.fatal("fatal");
    }

}
