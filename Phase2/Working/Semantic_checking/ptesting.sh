#! bin/sh
reset
java org.antlr.Tool Tiger.g

javac *.java

java TigerMain < testing.tig

rm *.class

