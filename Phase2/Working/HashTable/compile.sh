#! bin/bash

java org.antlr.Tool Tiger.g

javac *.java

java TigerMain < testcase.tig
