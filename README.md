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

# 9. List of websites to practice selenium
https://phptravels.com/demo/
https://s1.demo.opensourcecms.com/wordpress/
https://www.hubspot.com/
https://www.gumtree.com/
https://mailchimp.com/
https://www.freshworks.com
https://www.vtiger.com


# 9. Supported Properties
cucumber.ansi-colors.disabled=  # true or false. default: false
cucumber.execution.dry-run=     # true or false. default: false
cucumber.execution.limit=       # number of scenarios to execute (CLI only).
cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
cucumber.execution.wip=         # true or false. default: false.
cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
cucumber.filter.name=           # regex. example: .*Hello.*
cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
cucumber.glue=                  # comma separated package names. example: com.example.glue
cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
cucumber.snippet-type=          # underscore or camelcase. default: underscore