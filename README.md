# Assignment

[Click here to read the assignment](./docs/assignment.md)

## vanilla

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started

For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

Tip: Do remember to update this readme file for anything else that you think needs updating here!

## Success

============================================================================================================================================================

# Anit Sarker's Comments for the given problem and steps followed to solve
- **The given problem is solved successfully and can be run on Localhost, Docker Container and Docker-Selenoid** 
    - There is no change in the framework for running the test locally.
    - There is no change in the framework for running the test on Grid using Docker.
    - I have added a Dockerfile which will build the docker image of the tests. Follow the below steps to run the test on Docker container hosted locally on yoyr machine.
        1. run "docker build -t imagename:tag ." from root.
        2. run "docker run -d selenium/standalone-chrome-debug:latest". This will start the chrome browser in a docker container.
        3. run your built image using "docker run -ti --network="host" imagename/tag /bin/sh". We are opening the shell in the built docker to run our commands.
        4. move to pom.xml using "cd /home/AmazonTestSuite"
        5. Run "mvn clean test".
        
      ***NOTE: Before creating the Docker Image you must update the HOST property value to docker container in the "Choices.conf" config file***
    - Implemented Page Object Model and pages are stored in "src/main/java/amazonPages"
    - The End-to-End test written in "ClipBoardChallenge.AmazonTest.java" class.
    - Used @BeforeMethod and and @AfterMethod for Setup and Teardown methods of browsers.
    - The Test is running fine in Chrome and Firefox browsers.
    - The Test is running fine in Grid using Docker.
    - The Test is running fine in Docker Container.
    
============================================================================================================================================================
