java -jar TIGGER.jar small_sample.tig > resultS.txt

javac *.java

java ReadFile1 resultS.txt > IRs.txt

java CFG IRs.txt
