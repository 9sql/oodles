package httpsetup

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scala.collection.mutable.ListBuffer
import io.gatling.core.controller.inject.InjectionStep
import io.gatling.http.protocol.HttpProtocolBuilder


class HttpSetup {
  
    def injectParameters() : ListBuffer[InjectionStep] = {
    val nbUsers = Integer.getInteger("users", 1)
    val rampUpUsers = Integer.getInteger("rampUpUsers", 0)
    val rampUpDuration = Integer.getInteger("rampUpTime", 0)
    val rampUpUsersTo = Integer.getInteger("rampUpUsersTo", 0)
    val constantUsers = Integer.getInteger("constantUsers", 0)
    val constantUsersDuration = Integer.getInteger("constantUsersDuration", 0)
    var injectionSteps = new ListBuffer[InjectionStep]()
    injectionSteps+=nothingFor(10);
    
//    for(seed <- 100 to 2000 by 100)
//    {
//      injectionSteps+=atOnceUsers(seed)
//      injectionSteps+=nothingFor(200);
//    }
   // injectionSteps+=rampUsersPerSec(100)to(2000)during(200)
   // injectionSteps += splitUsers(2000) into(rampUsers(100) over(10)) separatedBy(10)
    
//    injectionSteps+=nothingFor(10);
    //set at once users
    if(nbUsers > 0)
    {
      injectionSteps+=atOnceUsers(nbUsers)
    }
//    
    if(constantUsers >0)
    {
     
      injectionSteps += constantUsersPerSec(constantUsers.toDouble) during(constantUsersDuration)
    }
    
//    //set ramup parameters
    if(rampUpUsers > 0 && rampUpDuration>=0)
   {
      if(rampUpUsersTo > 0)
      {
         injectionSteps+=rampUsersPerSec(rampUpUsers.toDouble)to(rampUpUsersTo.toDouble)during(rampUpDuration)
      }
      else
      {
        injectionSteps+=rampUsers(rampUpUsers)over(rampUpDuration)
      }
    }
       return injectionSteps;
    }
   
    
    def getHttpSetup():HttpProtocolBuilder={
      return http.baseURL("https://www.google.com")
    }
   
    def getHttpSetup(url:String):HttpProtocolBuilder={
      if(!url.isEmpty())
        return http.baseURL(url)
      else
        return getHttpSetup()
    }
  
}