# E-mail-Client-Service

Problem Statement: Ceate web service to send e-mail based on mail service using TO, FROM, CC, BODY TEXT.

User Stories:

Web Service Design:

Tasks
1. Shell of web api

2. Mail Service
      https://www.tutorialspoint.com/java/java_sending_email.htm

3. Wrap BODY TEXT in HTML
     add <body> </body> tags to BODY TEXT
     parse text for new line character (\n) to add <p> </p> tags

4. respond with string
     success or failure
       failure will have message
         parse service response and provide custom message
           build custom message on fly based on incomming message

Task Assignments:
Siva - 1 & 3 - Shell plus tag attachment for body text
Majeed - 4 - respond with string response (success/failure parsing)
Andy - 2 Mail Service 

Infrastructure Tasks
Create Team Slack channel
Unit Testing - create test cases for code per users
create a shell call OR implement in individual project for final test


Target Dates
Week 9 -  First code review.
Week 10 - Peer final code review.
Week 11 - Unit Testing Done, code coverage review.
Week 12 - Done Done!
