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


Infrastructure Tasks
Create Team Slack channel
Unit Testing - create test cases for code per users
create a shell call OR implement in individual project for final test

