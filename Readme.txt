Application for displaying currency exchange rates history. Data is retrieved from ECB and stored in the local DB.

run application with command "mvn spring-boot:run" in the root project directory.
Then open localhost:8080/index.html in your internet browser.

Solution built by Java 8 and maven 3.x.

Solutions:
  - Spring boot is used for launching application
  - configuration is in java lt.ciziunas.exchange.config package
  - jaxb is responsible for xml -> java binding
  - jaxb dto classes are generated from xsd. Then classes are modified to get a better code readability
  - DB is just a singleton class containing hashmap<currencyName, Currency>, where Currency contains date and rate
  - avoiding direct calls to DB, dao layer added
  - daily update is executed at midnight in server time. (Spring scheduling with cron expression)
  - history update executes on spring startup in the new thread.
  - frontend is implemented using Angular.js

If you have any questions - ask. I can explain my desicions and tell you where the app can be improved.

Marius
mr.marius.c@gmail.com

#EnjoyIT
