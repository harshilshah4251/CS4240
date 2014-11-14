#! /bin/sh

java org.antlr.Tool Tiger.g

javac *.java

java TigerMain < mytest.tig

rm *.class
