# Trading Orders for Securities
This Spring application is a maven project. It exposes a rest API that talks to an in memory H2 database to perform some asynchronous order summary analysis of trade orders. An order consists of the following attributes:
* Order Id
* Side (BUY or SELL)
* Security
* Fund
* Quantity
* Price

## What you will need
* [Intellij IDE](https://www.jetbrains.com/idea/) not necessary, but is highly recommended for Spring applications.

## Building and running the application
* Intellij has support for maven dependencies. You should use ```spring-boot-maven-plugin```.
* Use a shell and go to the project root directory (where the ```pom.xml``` file is) and type:
```
$ mvn clean package
```
This should build your .jar file in the target folder. Make sure port 8080 is not already in use — it’s the default port chosen by Tomcat. Change directories into the target folder. You should see the jar file in here. Build it by running:
```
$ java -jar <fileName>.jar
```


