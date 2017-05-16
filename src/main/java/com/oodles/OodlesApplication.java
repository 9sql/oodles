package com.oodles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.gatling.app.Gatling;

@SpringBootApplication
public class OodlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OodlesApplication.class, args);
		
		 List<String> parameters = new ArrayList<String>();
         parameters.add("-sf=/Users/rgora1/Documents/workspace_neene/oodles/build/classes/main");
         parameters.add("-s=simulations.OodlesSimulation");
         parameters.add("-rf=/Users/rgora1/Documents/workspace_neene/oodles/report/");
         String[] parametersArray = new String[parameters.size()];
         parametersArray = parameters.toArray(parametersArray);
		Gatling.main(parametersArray);

//		ProjectConnection connection = GradleConnector.newConnector().forProjectDirectory(new File("./"))
//				.connect();
//	          try {
//	              BuildLauncher build = connection.newBuild();
//	              build.forTasks("gatling");
//	              List<String> parameters = new ArrayList<String>();
//	              parameters.add("-Pusers=1");
//	              parameters.add("-PrampupUsers=2");
//	              parameters.add("-PrampupTime=2");
//	              parameters.add("-PtestToRun=OodlesSimulation");
//	              parameters.add("-PreqAuth=Y");
//	              String[] parametersArray = new String[parameters.size()];
//	              parametersArray = parameters.toArray(parametersArray);
//	              build.withArguments(parametersArray);
//	              build.setStandardOutput(System.out);
//	              build.run();
//	          } finally {
//	             connection.close();
//	          }
		
	}
}
