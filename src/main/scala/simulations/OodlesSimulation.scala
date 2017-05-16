package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef
import scala.collection.mutable.ListBuffer
import io.gatling.core.controller.inject.InjectionStep
import io.gatling.core.structure.ScenarioBuilder
import com.sun.webkit.network.CookieJar
import io.gatling.http.Predef
import io.gatling.http.check.HttpCheck
import io.gatling.core.structure.PopulationBuilder
import httpsetup.HttpSetup
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Scenario
import io.gatling.core.structure.ScenarioBuilder


class OodlesSimulation extends Simulation {
  
   val httpSetup = new HttpSetup();
   println("helloooooo===>  "+System.getProperty("test"))
   val httpConf =httpSetup.getHttpSetup(System.getProperty("test"))
   val apiUrl = if(System.getProperty("apiUrl") != null) System.getProperty("apiUrl") else "/login"
   httpConf.contentTypeHeader("application/json")
   val scenerioName = "Generic";
  
     
  setUp(
     getScenerioBuiders(scenerioName, apiUrl).readOnly).assertions(forAll.failedRequests.count.is(0)
  )
  
  
  def getScenerioBuiders(scenarioName:String,requestPath:String):ListBuffer[PopulationBuilder]=
  {
    var populationBuilders =  ListBuffer[PopulationBuilder]()

             var scn = scenario(scenarioName)
              scn =scn.exec(http("helo").get("https://www.google.com/"))
              populationBuilders+=scn.inject(atOnceUsers(1)).protocols(httpConf)
          
    return populationBuilders
  }
  
  
}