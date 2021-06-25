Popeye
===

Time:   3 weeks

Team:   2

Language:   Yaml


Project
----
Docker is one of today’s most popular containerization software.

It allows the packaging of applications, and the runtime environments (down to the operating systems) they need, which in return allows them to work wherever Docker is installed.

Like the brave sailor that Popeye is, containers can also confidently sail across the vast ocean of operating systems and configurations, being sure of working wherever they might end. As such, containers can be used on any host OS where Docker is installed.

During this project, you are going to master the basics of containerizing applications and describing multicontainers
infrastructures with Docker and Docker Compose.

# ENVIRONNEMENT 

You will have to containerize and define the deployment of a simple web poll application.
There are five elements constituting the application:
* **Poll**, a Flask Python web application that gathers votes and push them into a Redis queue.
* A **Redis queue**, which holds the votes sent by the Poll application, awaiting for them to be consumed by theWorker.
- **TheWorker**, a Java application which consumes the votes being in the Redis queue, and stores them into a PostgreSQL database.
* A **PostgreSQL database**, which (persistently) stores the votes stored by theWorker.
* **Result**, a Node.js web application that fetches the votes fromthe database and displays the. . . well, result. ;)