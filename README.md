# Assemble [![Build Status](https://travis-ci.org/thomasbiesaart/nefarious-weasel.svg?branch=master)](https://travis-ci.org/thomasbiesaart/nefarious-weasel) [ ![Download](https://api.bintray.com/packages/thomasbiesaart/maven/assemble/images/download.svg) ](https://bintray.com/thomasbiesaart/maven/assemble/_latestVersion)
Assemble is a little library that allows you to select random quotes. 

The name *Assemble* has been chosen so it can hide inside a list of dependencies without standing out.

## Step 1: Dependencies
To use this library you first need to declare the dependency

### Gradle
```Gradle
repositories {
  jcenter()
}

dependencies {
  compile 'org.jaxlan:assemble-norris:1.0.0'
}
```
### Maven
```xml
<project>
...

<repositories>
  <repository>
    <id>jcenter</id>
    <url>https://jcenter.bintray.com/</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>org.jaxlan</groupId>
    <artifactId>assemble-norris</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>

...
</project>
```


## Step 2: Quotes
Now all you have to do is call `String result = Assemble.assemble();` and print this message to an original place!
