/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon.ExternalPropertiesReading;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.Properties;
/**
 *
 * @author exodus
 */
public class ConfigfileReading {
    Properties prop = new Properties();
    InputStream inputstream ;
    
    
   public ConfigfileReading()
   {
        //configFile = new java.util.Properties();
        
        try {
      
        inputstream = new FileInputStream("/usr/local/myDaemon/config.properties");
      
     
        }catch(Exception eta){
            eta.printStackTrace();
        }
   }
 
   public String getProperty(String key)
   {
       try{
        if(inputstream!=null)
            {
                prop.load(inputstream);
                
                return prop.getProperty(key);
        }else{
                System.out.println("File not found");
                return "no file found";
        }
      }catch(Exception e){
          e.printStackTrace();
         
      }
        return null;
        
   }
   
  

}
