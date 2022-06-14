FROM maven:3.8.5-jdk-11

COPY src /home/AmazonTestSuite/src

COPY pom.xml /home/AmazonTestSuite

COPY testng.xml /home/AmazonTestSuite

RUN mvn -f /home/AmazonTestSuite/pom.xml clean test -DskipTests=true
