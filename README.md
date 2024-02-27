# UI Automated tests for the app
* These are the UI Tests for the shopping cart portal
* Tests are written in Java
* Tool which is used for UI automation is Selenium V4.0
* Cucumber is used as an BDD instrument
* Features files are written with the help of Cucumber BDD 
* Maven is used as a build tool 
* Tests are written to work with Chrome 109 or higher

# Pre-requisites for running the tests 
* Java must be installed on system - Java 8 or higher 
* Maven must be installed on system - Maven 3.8 or higher
* Reference for installing maven is : https://maven.apache.org/install.html
* latest Chrome browser must be installed , please note it should be version 109 or higher

# How to run the tests locally
- Clone the repo with the help of command
  ```git clone <path of the repo>  ```
- Now navigate to the root folder where you have cloned the repo 
- From the root run the below command :
  ```mvn clean test  ```
- above command will run the tests, and you can see that tests will be running in Chrome browser

# How to run the tests on CircleCI tool 
- Clone the repo with the help of command
  ```git clone <path of the repo>  ```
- After cloning, push the complete project to your own Git repository.
- Login to the CircleCI app using your Git credentials.
- In the CircleCI app, set up the project by configuring the config.yml file available in the .circleci folder. 
- This file allows you to define your test execution environment and specify the commands to run your tests.
- The default setup method in CircleCI, known as the "Fastest" way, is recommended for setting up the project quickly.
- Once the project is set up, trigger the build on CircleCI. The configured tests will be executed as part of the build process.

