# JSON4Java
My implementation of methods handling JSON data in Java. The parser and lexer used here were appropriated and translated from Eaton Phil's awesome pj library found at https://github.com/eatonphil/pj/blob/master/pj/lexer.py

## Usage
Grab a JAR from the release page or clone this project and insert it into
your project. To make a JSON object that contains your information, 
create a new instance of the JSONObject class like this:

```java
JSONObject json = new JSONObject();
```
### Adding information
```java
json.addRule("name", "Mweya");
json.addRule("age", 20);
```
This even works for arrays!
```java
int[] ages = {12, 23, 55};
json.addRule("ages", ages);
```
Documents and arrays of rules can be added in a similar fashion:
```java
JSONObject location = newJSONObject();
location.addRule("lat", 31.445363);
location.addRule("long", 23.343567);
json.addRule("location", location);
```
### Searching for rules
```java
JSONRule rule = json.searchSelector("name");
```
### Deleting rules
```java
json.deleteRule("name");
json.removeRule("city");
```
Rules at a certain index can be deleted in a similar fashion:
```java
json.deleteRule(2);
```
### Writing to a file
```java
json.toFile("file.json");
```
