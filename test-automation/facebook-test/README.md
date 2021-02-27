# facebook-test
Demo testcases on facebook login scenarios using: java, selenium, testng, extent-report, screenshot-robot, excel-util and others.

**NB: Used facebook-developer to create test users and grant them login permission.**


## Prerequisites

- Download and Install JDK 8
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Add the installed JDK’s bin folder location to system environment variables
- Download and install IntelliJ IDE
https://www.jetbrains.com/idea/download


## How to setup

Finished installations? let’s clone our shared Automation project.
- Open IntelliJ IDE
- Select “Get from Version Control”
- Add the project’s Repo URL https://github.com/PierreKhouzam/pierre-khouzam.git
- Click on “Clone”

Once the project is cloned, make sure JDK 1.8 is added to your project’s structure and all Pom file’s dependencies are updated.
- Add pom.xml as maven project
- Run maven clean install when its ready (You can let maven skips test while building from maven settings)


## How to run

In order to run the existing tests, you need to
- Open testng.xml file and run using TestNG
- Or open test classes and run using TestNG


## Testcases

Module: Login
Testcases: testdata/LoginTestData.xlsx

**Testcases are divied into (Localization, Validation, Standalone and Happy) scenarios**

*LocalizationScenarios*
- TC - 0001	Check that username placeholder is as expected
- TC - 0002	Check that password placeholder is as expected
- TC - 0003	Check that login button text is as expected
- TC - 0004	Check that forgotten password link text is as expected
- TC - 0005	Check that that create account button text is as expected

*ValidationScenarios*
- TC - 0006	Check that user can’t login with invalid email and invalid password
- TC - 0007	Check that user can’t login with valid email and invalid password
- TC - 0008	Check that user can’t login with invalid email and valid password
- TC - 0009	Check that user can’t login with valid email and empty password
- TC - 0010	Check that user can’t login with empty email and valid password
- TC - 0011	Check that user can’t login with empty email and password

*HappyScenarios*
- TC - 0012	Check that user can login with valid email and password
- TC - 0012	Check that user can login with valid email and password
- TC - 0012	Check that user can login with valid email and password
- TC - 0012	Check that user can login with valid email and password

*StandaloneScenarios*
- TC - 0013	Check that password is shown/hidden on toggle	
- TC - 0014	Check that user can navigate to forgotten password page successfully	
- TC - 0015	Check that user can navigate to Create New Account page successfully	
