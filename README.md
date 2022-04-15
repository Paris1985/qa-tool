
#browserstack https://automate.browserstack.com/
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DACCESS_KEY=${access key} -DUSERNAME=${username} -DSERVER=${server} -DREMOTE=browserstack -DBROWSER=${browser}
#saucelabs https://saucelabs.com/
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DACCESS_KEY=${access key} -DUSERNAME=${username} -DSERVER=${server} -DREMOTE=saucelabs -DBROWSER=${browser}
#To Run in local grid
prerequisite : 
Grid server is running locally
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DBROWSER=${browser}
#To Run in stand alone webdriver
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DBROWSER=${browser}

#browser value options 
edge,
chrome,
firefox,
safari,
ie

#server examples -please check remote server account for details
browserstack: hub-cloud.browserstack.com/wd/hub
saucelabs: ondemand.eu-central-1.saucelabs.com:443/wd/hub

#Provide Username and Access Key in the -D options or setup in environment variables


