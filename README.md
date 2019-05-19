# JSON4Java
My implementation of methods handling JSON data in Java.

## Usage
Grab a JAR from the release page or clone this project and insert it into
your project. To make a JSON object that contains your information, 
create a new instance of the JSONObject class like this:

```java
JSONObject json = new JSONObject();
```
and add your information like this:

```java
json.addRule("name", "Mweya");
```

A JSONObject of my type has support for searching for rules by selector,
```java
JSONRule rule = json.searchSelector("name");
```
support for deleting a rule,
```java
json.deleteRule("name");
json.removeRule("city"); // This works too
json.deleteRule(2);
```
and can write itself to a file
```java
json.toFile("file.json");
```
