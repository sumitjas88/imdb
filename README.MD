# API Documenation

### Movie
```javascript

{
    "id":490,
    "name":"The Hobbit: An Unexpected Journey",
    "releaseDate":null,
    "mpaaRating":{
        "code":"PG-13",
        "description":"Parental Guidance Cautioned"
    },
    "runtime":169,
    "cast":[{
        "id":493,
        "artist":{
            "id":492,
            "name":"Ian McKellen"
        },
        "character":{
            "id":491,
            "name":"Gandalf"
        }
    }]
}
```
**Get All Movies**
```
GET http://localhost:8080/movies/
```
**Create a Movie**
```sh
POST http://localhost:8080/movies/
```
**Get a Single Movie**
```sh
GET http://localhost:8080/movies/{id}
```
**Delete a Movie**
```sh
DELETE http://localhost:8080/movies/{id}
```
**Update a Movie**
```sh
PUT http://localhost:8080/movies/{id}
```
***To Run The Project***
'''sh
cd myapp/
run cmd ==> ./gradlew clean build
rub MyappAllpication.java
0r
java -jar build/libs/myapp-0.0.1-SNAPSHOT.jar

***setting the postgres***
go to application.properties, change the database name, user and password according to your setting.
