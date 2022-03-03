# Tests Structure
**Java/Cucumber/Selenium Grid Test Case Automation Documentation**

**Summary:**
Scope development for test case automation using the BDD technique (Behavior Driven Development) or Design/Development guided by behavior.

### Tags ###

Informations about the tags

# Tools used:
**IDE:** Eclipse
**IDE:** Intellij


# Frameworks/Dependencies:
- **Maven** - builder and version control
- **Cucumber** - it is a software tool that supports bdd
- **Selenium Webdriver** - it is responsible for handling Web elements
- **Selenium Grid** - it is a smart proxy server that makes it easy to run tests in parallel on multiple machines remotely
- **Junit** - it is responsible for unit tests and regression tests
- **ExtentReports** - it is responsible for generating the Html report of the executions
- **Maven-surefire-plugin** - it is responsible for generating .txt file with failed tests
- **Dotenv-java** - it is responsible for loading environment variables from a .env file
- **Ashot** - it is responsible for take the fullscreen screenshoot
- **Lombok** - it is a library that helps IDE to ignore generating boiler plate code
- **log4j-slf4j-impl** - allows applications coded to the SLF4J API to use Log4j 2 as the implementation
- **jansi** - To enable log colours on windows machines
- **selenium-remote-driver** - It is used to execute the browser automation suite on a remote machine
- **query** - It is a query object designed to make page objects easier to manage
- **cucumber-junit-platform-engine** - This will allow IntelliJ IDEA, Eclipse, Maven, Gradle, etc, to discover, select and execute Cucumber scenarios
- **junit-platform-suite** - Test suites can be run on the JUnit Platform in a JUnit 5 environment via @Suite with the junit-platform-suite-engine
- **junit-jupiter** - Module "junit-platform-suite-api" of JUnit 5
- **testng-junit5** - Implementation of the JUnit5 Platform TestEngine interface
- **driver-binary-downloader-maven-plugin** - A Maven plugin that will download the WebDriver stand alone server executables for use in your mavenised Selenium project
- **assertj-core** - Rich and fluent assertions for testing for Java
- **maven-compiler-plugin** - The Compiler Plugin is used to compile the sources of your project

# Folders Structure:
- **Config** - it is responsible for specific environment configurations
  - **BrowserFactory** - folder that contains all browsers setups
    - **DriverFactory** - it is responsible for instantiating webdriver and keep browser instance
    - **DriverSetup** - class that supports DriverFactory
    - **DriverType** - class that has setups for FIREFOX,CHROME,IE,EDGE,SAFARI,OPERA,BRAVE
  - **DriverBase** - setups for suite
  - **ExtentReports** - it is responsible for generating the Html report of the executions
  - **Hooks** - it is responsible for setting up some configurations before or after any test runs
- **Resources** - location where project features are stored
  - **Features** -  location where project features are stored
- **Pages** - location where are stored files responsible fo the interactions of mapped elements
- **Runners** - location where project runners class are stored
- **Step_Definitions** - location where project step class are stored

# Environment Setup:
- **Install java development environment**
  - **Windows**- https://vinayrajsingh.medium.com/how-to-setup-java-development-environment-on-windows-ba4b46c0eebc
  - **Mac**- https://medium.com/macoclock/setting-up-your-macbook-for-java-development-102-f50cbaa18350
- **Install Maven environment**
  - **Win/Mac/Linux**- https://www.baeldung.com/install-maven-on-windows-linux-mac
- **Cucumber Install**
  - **Eclipse**- Click on Help > Install New Software > Type in "Work With" field > https://maven.apache.org/download.cgi
- **Add Maven Dependencies and Plugins in the POM.xml**<br />
  Versions used on the date of creation of this structure (02/02/2022).
  - **cucumber-java** - 7.2.2
    - **selenium-java** - 4.1.0
    - **cucumber-junit** - 7.2.2
    - **extentreports** - 5.0.9
    - **dotenv-java** - 2.2.0
    - **ashot** - 1.5.4
    - **lombok** - 1.18.22
    - **maven-surefire-plugin** - 3.0.0-M5
    - **java** - 11
    - **assertj-core** - 3.21.0
    - **jansi** - 2.3.4
    - **log4j** - 2.17.1
    - **query** - 2.0.0-BETA3
    - **testng** - 7.3.0
    - **driver-binary-downloader-maven-plugin** - 1.0.18
    - **maven-compiler-plugin** - 3.8.1
    - **testng-junit5** - 0.0.1

# First steps:
    Open a terminal window/command prompt
    Clone this project.
    cd Fireworks_Test_Automation (Or whatever folder you cloned it into)
    mvn clean verify
    All dependencies should now be downloaded and test will have run

# Run by Intellij IDE locally using Runner class:
    Go to RunCucumberIT class
    Set a tag on IncludeTags
    Go to edit configurations > Junit > RunCucumberIt
    Set in Environment Variables = APP_URL=https://dev.local.fireworkscrm.net/login
    Click on Run button

# Run by Intellij IDE locally using Cucumber:
    Go to edit configurations > Cucumber > add feature ou scenario
    Set in Environment Variables = APP_URL=https://dev.local.fireworkscrm.net/login
    Click on Run button

# Run failed tests by Intellij IDE locally:
    Go to RunFailedTestsCucumberIT class
    Go to edit configurations > Junit > RunCucumberIt
    Set in Environment Variables = APP_URL=https://dev.local.fireworkscrm.net/login
    Click on Run button

# Run by Intellij IDE remotely:
    Go to edit configurations > Cucumber > add feature ou scenario
    Set in Environment Variables = APP_URL=https://dev.local.fireworkscrm.net/login
    Set in VM Options = -Dbrowser=chrome -DgridURL=http://{username}:{accessKey}@ondemand.saucelabs.com:80/wd/hub -DremoteDriver=true -Dheadless=false 
    Click on Run button

# Run by Command line:
    docker-compose up
    docker-compose build test-runner
    docker-compose run --rm test-runner

### What should I know?

- To run any unit tests that test your Selenium framework you just need to ensure that all unit test file names end, or start with "test" and they will be run as part of the build.
- The maven failsafe plugin has been used to create a profile with the id "selenium-tests". This is active by default, but if you want to perform a build without running your
  selenium tests you can disable it using:
```shell
mvn clean verify -P-selenium-tests
```

- The maven-failsafe-plugin will pick up any files that end in IT by default. You can customise this is you would prefer to use a custom identifier for your Selenium tests.

### Known problems...

- It looks like SafariDriver is no longer playing nicely and we are waiting on Apple to fix it... Running safari driver locally in server mode and connecting to it like a grid
  seems to be the workaround.

### Anything else?

Yes you can specify which browser to use by using one of the following on the command line:

- `-Dbrowser=firefox`
- `-Dbrowser=chrome`
- `-Dbrowser=ie`
- `-Dbrowser=edge`
- `-Dbrowser=opera`
- `-Dbrowser=brave`

If you want to toggle the use of chrome or firefox in headless mode set the headless flag (by default the headless flag is set to true)

- `-Dheadless=true`
- `-Dheadless=false`

You don't need to worry about downloading the IEDriverServer, EdgeDriver, ChromeDriver , OperaChromiumDriver, or GeckoDriver binaries, this project will do that for you
automatically.

You can specify a grid to connect to where you can choose your browser, browser version and platform:

- `-Dremote=true`
- `-DseleniumGridURL=http://{username}:{accessKey}@ondemand.saucelabs.com:80/wd/hub`
- `-Dplatform=xp`
- `-Dbrowser=firefox`
- `-DbrowserVersion=44`

You can even specify multiple threads (you can do it on a grid as well!):

- `-Dthreads=2`

You can also specify a proxy to use

- `-DproxyEnabled=true`
- `-DproxyHost=localhost`
- `-DproxyPort=8080`
- `-DproxyUsername=fred`
- `-DproxyPassword=Password123`

If the tests fail screenshots will be saved in `${project.basedir}/target/screenshots`

If you need to force a binary overwrite you can do:

- `-Doverwrite.binaries=true`

### It's not working!!!

You have probably got outdated driver binaries, by default they are not overwritten if they already exist to speed things up. You have two options:

- `mvn clean verify -Doverwrite.binaries=true`
- Delete the `selenium_standalone_binaries` folder in your resources directory

### Brave fails when in headless mode

Currently, Brave seems to be a bit flaky when running in headless mode, I would suggest running with `-Dheadless=false`

### It's looking for the Brave binary in the wrong location

You probably don't have the brave binary installed in one of the default locations that this codebase is expecting.  That's OK though, you can specify it by seeting the following system property:

- `-DbraveBinaryLocation=/path/to/brave-browser`
