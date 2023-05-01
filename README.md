user: user

# How to build the project

```
./gradlew build
```

or 

```
gradlew build
```

# How to run the project

```
./gradlew run
```

or

```
gradlew run
```

# How to start mysql database 

The following mysql container will use the definitions from init.sql to populate and create the database
```
docker-compose up
```

To access phpMyAdmin to manage database go in your browser to http://localhost:8080

Host: mysql
User: root
Password: 12345