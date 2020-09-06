Random Word Microservice Project


To run tests:

    mvn test
    
To build and run:

    run.sh

    or

    mvn spring-boot:run

To fetch a random word, visit (GET):

    https://host:port/api/word

To add a word to the list, POST with request body: 

    {"word":"test"}
    

To get word length from path: http://localhost:8080/api/word/testword/length

---

To build docker container:
    
    sudo mvn package dockerfile:build

To run docker:

    sudo docker run thxword/wordserver:0.0.1-SNAPSHOT
