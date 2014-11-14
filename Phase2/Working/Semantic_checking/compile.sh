#! bin/bash

java org.antlr.Tool Tiger.g

javac *.java

java TigerMain < testcase01.tig

rm *.class
