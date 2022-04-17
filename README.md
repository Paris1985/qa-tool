# 1. Prerequisite 
<strong>Remote Grid Server: </strong> Create saucelabs or browserstack account for remote server<br>
<strong>Local Grid Server: </strong> setup grid server on your local machine<br>
<strong>Stand Alone:</strong> go to #6 
# 2. browserstack https://automate.browserstack.com/
<strong>command: </strong>
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DACCESS_KEY=${access key} -DUSERNAME=${username} -DSERVER=${server} -DREMOTE=browserstack -DBROWSER=${browser}
# 3. saucelabs https://saucelabs.com/
<strong>command: </strong>
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DACCESS_KEY=${access key} -DUSERNAME=${username} -DSERVER=${server} -DREMOTE=saucelabs -DBROWSER=${browser}
# 5. To Run in local grid
<strong>prerequisite : </strong>
Grid server is running locally <br>
<strong>command: </strong>
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DREMOTE=${local_grid} -DBROWSER=${browser}
# 6. To Run in stand alone webdriver 
-check #7 for browser options
mvn clean test -Dtest="org.qa.tool.cucumber.CucumberTest" -DBROWSER=${browser}

# 7. browser value options 
edge <br>
chrome <br>
firefox </br>
safari </br>
ie
# 8. server examples -please check remote server account for details
<strong>browserstack:</strong> hub-cloud.browserstack.com/wd/hub <br>
<strong>saucelabs:</strong> ondemand.eu-central-1.saucelabs.com:443/wd/hub




