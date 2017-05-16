package com.oodles;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.gatling.app.Gatling;

@SpringBootApplication
public class OodlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodlesApplication.class, args);
		 Properties props = System.getProperties();
		 props.setProperty("test", "test");
		 List<String> parameters = new ArrayList<String>();
         parameters.add("-sf=/Users/rgora1/Documents/workspace_neene/oodles/build/classes/main");
         parameters.add("-s=simulations.OodlesSimulation");
         parameters.add("-rf=/Users/rgora1/Documents/workspace_neene/oodles/report/");
         String[] parametersArray = new String[parameters.size()];
         parametersArray = parameters.toArray(parametersArray);
         CustomController securityController = new CustomController(); 
         try{
        	 securityController.disableSystemExit();
        	 Gatling.main(parametersArray);
         }
         finally {
        	 securityController.enableSystemExit();
		}
		
		
	}
	
	
}