# Shape Calculator


###To build the project, run
```
mvn clean install
```

### To run it move to the target package, and run 
```
java -jar shape-calculator-0.0.1-SNAPSHOT.jar
```

##About requsets
### For now we allow such shapes:
 > RECTANGLE, TRIANGLE, CIRCLE, SQUARE  

When you run the project, you can make request for url
```
http://localhost:8080/calculate
```
With JSON body, examples 
```
{
  "shape": "TRIANGLE",
  "firstParameter": 5.0,
  "secondParameter": 4.0,
  "thirdParameter": 3.0
}
```

```
{
  "shape": "RECTANGLE",
  "firstParameter": 5.0,
  "secondParameter": 2.0
}
```

```
{
  "shape": "SQUARE",
  "firstParameter": 5.0
}
```

```
{
  "shape": "CIRCLE",
  "firstParameter": 6.0
}
```
