#!bin/bash

java org.antlr.Tool Tiger.g

javac HashTable/*.java Tiger*.java



java TigerMain < testcase01.tig

rm *.class
