# Test Automation

## Setting up your environment

To run this project, you will need [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
, [Maven](https://maven.apache.org) and [Git](https://git-scm.com/downloads).
You will also need a modern Java IDE such as [IntelliJ IDE](https://www.jetbrains.com/idea/download)
(this is our recommendation - the free Community Edition will do fine).
 Make sure that the bundled [Cucumber for Java plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java) is enabled.


## Use Maven

Open a command window and run: 

    mvn clean verify
    
This command will run all the tests 

    
##Running scenarios by tags

With Cucumber framework, you need to use the cucumber.options system property for tests filtering:


    mvn clean verify -Dtags="WebFE"
    
Run ApiRest Test by filtering: 
 
    mvn clean verify -Dtags="ApiRest"
    
## Simple test contexts
Run your tests using the Chrome WebDriver, providing a context called "chrome"

     mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome
     
Run the tests again (or in parallel, on a different machine) using Firefox:

    mvn verify -Dcontext=firefox -Dwebdriver.driver=firefox
    
## Adding more readable tags
Serenity will add a "context" tag to each of your tests, but you might want to make your reports even clearer by 
adding a more meaningful tag. You can do this using the "injected.tags" system property:
 
    mvn verify -Dcontext=chrome -Dwebdriver.driver=chrome -Dinjected.tags="browser:chrome" 
      
## Aggregating test results 

Once the tests have completed, open a command window and run: 

    mvn serenity:aggregate -Dserenity.outputDirectory=serenity-reports
    
This command will generate the report that it is going to be in the following path: 

`serenity-report`
    

## Viewing the reports

The command provided above will produce a Serenity test report in the `serenity-reports` directory. Go take a look!

![](src/docs/report.png)